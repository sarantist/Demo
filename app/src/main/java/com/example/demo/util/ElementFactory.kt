package com.example.demo.util

import androidx.compose.runtime.Composable
import com.example.demo.model.Element
import com.example.demo.ui.components.ButtonComponent
import com.example.demo.ui.components.TextComponent

@Composable
fun ElementFactory(element: Element) {
    when (element) {
        is Element.TextElement -> {
            TextComponent(element)
        }
        is Element.ButtonElement -> {
            ButtonComponent(element)
        }
        is Element.ImageElement -> {
            // not implemented
        }
    }
}