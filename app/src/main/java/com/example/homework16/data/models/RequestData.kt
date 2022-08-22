package com.example.homework16.data.models

import com.squareup.moshi.Json

data class RequestData(
    val page: Int,
    @Json(name = "per_page")
    val perPage: Int,
    val total: Int,
    @Json(name = "total_pages")
    val totalPages: Int,
    val data: List<Data>,
    val support: Support
)