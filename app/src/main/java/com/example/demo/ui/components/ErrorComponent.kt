package com.example.demo.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun ErrorComponent(exception: Exception) {
    Text(
        text = "There was an error!! : ${exception.message}",
        style = MaterialTheme.typography.h2
    )
}