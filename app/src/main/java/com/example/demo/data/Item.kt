package com.example.demo.data

import com.example.demo.model.Element
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Item(val elements: List<Element> = emptyList())