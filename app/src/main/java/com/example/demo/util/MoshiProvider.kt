package com.example.demo.util

import com.example.demo.model.Element
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

// Singleton instance of Gson since there is no dependency injection implemented for this project
object MoshiProvider {
    val moshi: Moshi by lazy {
        val builder = Moshi.Builder()
            .add(
                PolymorphicJsonAdapterFactory.of(Element::class.java, "type")
                    .withSubtype(Element.TextElement::class.java, "elements/text")
                    .withSubtype(Element.ImageElement::class.java, "elements/image")
                    .withSubtype(Element.ButtonElement::class.java, "elements/button")
            )
        builder
            // always use addLast for adding the KotlinJsonAdapterFactory
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }
}