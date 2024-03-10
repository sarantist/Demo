package com.example.demo.ui.article

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.demo.model.Element
import com.example.demo.ui.home.ElementFactory
import com.example.demo.ui.theme.Spacing

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