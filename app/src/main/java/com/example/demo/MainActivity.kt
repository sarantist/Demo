package com.example.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.example.demo.data.FirebaseRepository
import com.example.demo.data.Response
import com.example.demo.model.Element
import com.example.demo.model.ElementType
import com.example.demo.ui.theme.DemoTheme
import com.example.demo.ui.theme.Spacing
import com.example.demo.util.GsonProvider
import com.example.demo.util.MoshiProvider

class MainActivity : ComponentActivity() {
    private val firebaseRepository = FirebaseRepository(GsonProvider.gson, MoshiProvider.moshi)
    private val viewModel = MainActivityViewModel(repository = firebaseRepository)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainComposable(viewModel)
                }
            }
        }
    }
}

@Composable
fun MainComposable(viewModel: MainActivityViewModel) {
    val dataState = viewModel.state.value
    when (dataState) {
        is DataState.Error -> {
            ErrorText(dataState.exception)
        }
        DataState.Loading -> {
            LinearProgressIndicator()
        }
        is DataState.Success -> {
            ArticleList(dataState.data)
        }
    }
}

@Composable
fun ArticleCard(elements: List<Element>) {
    Card(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(Spacing.Medium)) {
            elements.forEach { element ->
                ElementFactory(element = element)
            }
        }
    }
}

@Composable
fun ArticleList(data: Response) {
    val elements = data.items.map { it.elements }
    LazyColumn(
        contentPadding = PaddingValues(Spacing.Large),
        verticalArrangement = Arrangement.spacedBy(Spacing.Small)
    ) {
        items(elements) {
            ArticleCard(it)
        }
    }
}

@Composable
fun ErrorText(exception: Exception) {
    Text(
        text = "There was an error!! : ${exception.message}",
        style = MaterialTheme.typography.h2
    )
}

@Composable
fun ElementFactory(element: Element) {
    when (element) {
        is Element.TextElement -> {
            TextElement(element)
        }
        is Element.ButtonElement -> {
            OutlinedButton(onClick = { }, modifier = Modifier.fillMaxWidth()) {
                Text(element.text)
            }
        }
        is Element.ImageElement -> {
            // not implemented
        }
    }
}

@Composable
fun TextElement(element: Element.TextElement) {
    when (element.purpose) {
        ElementType.TextType.TITLE.value -> {
            Text(
                text = element.text,
                style = MaterialTheme.typography.h3,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
        ElementType.TextType.DESCRIPTION.value -> {
            Text(
                text = element.text,
                style = MaterialTheme.typography.body1,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

