package com.example.demo.util

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.demo.model.Element
import com.example.demo.ui.components.TextComponent

@Composable
fun ElementFactory(element: Element) {
    when (element) {
        is Element.TextElement -> {
            TextComponent(element)
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