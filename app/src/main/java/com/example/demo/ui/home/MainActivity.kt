package com.example.demo.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.demo.data.Response
import com.example.demo.ui.article.ArticleList
import com.example.demo.ui.components.ErrorComponent
import com.example.demo.ui.theme.DemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

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
private fun MainComposable(viewModel: MainActivityViewModel) {
    // Collect the StateFlow as state
    val uiState: UiState<Response> by viewModel.state.collectAsState()
    when (val state = uiState) {
        is UiState.Error -> {
            ErrorComponent(state.exception)
        }
        UiState.Loading -> {
            LinearProgressIndicator()
        }
        is UiState.Success -> {
            ArticleList(state.data)
        }
    }
}





