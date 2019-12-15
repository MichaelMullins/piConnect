package com.pi.connect

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://50.89.241.14"


fun buildPiApiService(): PiApiService =
    Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(PiApiService::class.java)

interface PiApiService {


    @GET("/")
    fun getBaseUrl(): Call<PiResponse>
}