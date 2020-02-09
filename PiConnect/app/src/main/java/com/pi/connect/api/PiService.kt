package com.pi.connect.api

import com.pi.connect.api.model.Script
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val port = ":5000/"

fun buildPiService(baseUrl:String): PiService {
    return Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .baseUrl(baseUrl + port)
        .build()
        .create(PiService::class.java)
}

interface PiService {

    @GET("piConnect/v1")
    suspend fun connectToPi()

    @GET("piConnect/v1/scripts")
    suspend fun getScripts(): List<Script>

    @GET("piConnect/v1/runScript")
    fun runScript(scriptId: Int): List<Script>


}