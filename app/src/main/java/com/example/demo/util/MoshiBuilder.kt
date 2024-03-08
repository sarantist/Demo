package com.example.demo.util

import com.example.demo.model.Element
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MoshiBuilder {
    private val builder = Moshi.Builder()
        .add(
            PolymorphicJsonAdapterFactory.of(Element::class.java, "type")
                .withSubtype(Element.TextElement::class.java, "elements/text")
                .withSubtype(Element.ImageElement::class.java, "elements/image")
                .withSubtype(Element.ButtonElement::class.java, "elements/button")
        )

    fun buildMoshi(): Moshi {
       return builder.addLast(KotlinJsonAdapterFactory()).build()
    }
}