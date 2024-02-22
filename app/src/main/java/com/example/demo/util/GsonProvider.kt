package com.example.demo.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder

// Singleton instance of Gson since there is no dependency injection implemented for this project
object GsonProvider {
    val gson: Gson by lazy {
        GsonBuilder().create()
    }
}