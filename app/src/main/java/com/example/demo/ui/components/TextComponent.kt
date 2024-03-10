package com.example.demo.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow
import com.example.demo.model.Element
import com.example.demo.model.ElementType

@Composable
fun TextComponent(element: Element.TextElement) {
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