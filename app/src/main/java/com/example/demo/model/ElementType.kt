package com.example.demo.model

enum class ElementType(private val _value: String) {
    TEXT("text"),
    IMAGE("image"),
    BUTTON("button");

    enum class TextType(val value: String) {
        TITLE("title"),
        DESCRIPTION("description"),
        DEFAULT("default")
    }

    val value: String
        get() = _value
}