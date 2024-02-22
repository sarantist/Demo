package com.example.demo.model

import com.squareup.moshi.JsonClass

// All components have the same base class
@JsonClass(generateAdapter = true)
open class Element(val type: String = "") {
    companion object {}

    @JsonClass(generateAdapter = true)
    class TextElement(val purpose: String = "", val text: String = "") : Element()

    @JsonClass(generateAdapter = true)
    class ImageElement(val purpose: String = "", val caption: String = "") : Element()

    @JsonClass(generateAdapter = true)
    class ButtonElement(val purpose: String = "", val text: String = "") : Element()
}