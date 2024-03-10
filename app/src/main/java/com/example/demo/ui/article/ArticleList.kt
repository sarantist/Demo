package com.example.demo.ui.article

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.demo.data.Response
import com.example.demo.ui.theme.Spacing

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