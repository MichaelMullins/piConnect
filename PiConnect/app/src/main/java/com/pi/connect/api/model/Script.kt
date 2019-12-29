package com.pi.connect.api.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Script(
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "id")
    val id: Int? = null
)