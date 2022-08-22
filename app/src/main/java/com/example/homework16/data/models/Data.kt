package com.example.homework16.data.models

import com.squareup.moshi.Json

data class Data(
    val id: Int,
    val email: String,
    @Json(name = "first_name")
    val firstName: String,
    @Json(name = "last_name")
    val lastName: String,
    val avatar: String
)
