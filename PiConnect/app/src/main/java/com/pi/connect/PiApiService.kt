package com.pi.connect

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "http://50.89.241.14"


fun buildPiApiService():PiApiService=
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .build()
        .create(PiApiService::class.java)

interface PiApiService {
@GET("")
fun getBaseUrl(): Response<String>
}