package com.example.demo.data

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Response(val items: List<Item> = emptyList())