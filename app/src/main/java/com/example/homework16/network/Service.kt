package com.example.homework16.network

import com.example.homework16.data.models.RequestData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("users?page=1")
    suspend fun requestData(@Query("page") page: Int): Response<RequestData>
}