package com.pi.connect.api

import com.pi.connect.api.model.Script
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "http://192.168.1.10:5000/"


fun buildPiService(): PiService {
    return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .build()
        .create(PiService::class.java)
}


interface PiService {

    @GET("piConnect/v1/scripts")
    suspend fun getScripts(): List<Script>

    @GET("piConnect/v1/runScript")
    fun runScript(@Query("id")scriptId: Int): List<Script>


}