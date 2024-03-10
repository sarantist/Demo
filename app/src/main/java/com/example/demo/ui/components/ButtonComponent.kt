package com.example.demo.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.demo.model.Element

@Composable
fun ButtonComponent(element: Element.ButtonElement) {
    OutlinedButton(onClick = { }, modifier = Modifier.fillMaxWidth()) {
        Text(element.text)
    }
}