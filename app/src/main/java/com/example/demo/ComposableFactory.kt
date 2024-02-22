package com.example.demo

import androidx.compose.runtime.Composable

//// Define a typealias for the Composable function
//typealias ComposableFactory<T> = @Composable (element: T) -> Unit
//
//// Map of Element types to their corresponding Composable factories
//val elementComposables: Map<String, ComposableFactory<Element>> = mapOf(
//    "text" to { element -> ElementTextView(element) },
//    "button" to { element -> ElementButtonView(element) }
//    // Add more mappings for other Element types as needed
//)
//
//@Composable
//fun <T : Element> createComposeViewForElement(element: T) {
//    val factory = elementComposables[element.type]
//    factory?.invoke(element) ?: Text("Unsupported element type: ${element.type}")
//}
//
//@Composable
//fun RootView(root: Root) {
//    root.items.forEach { item ->
//        item.elements.forEach { element ->
//            createComposeViewForElement(element)
//        }
//    }
//}
