package com.smk.futbol.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object WebClient {
    private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/"
    private val client = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val WEB_SERVICE: WebService = client.create(WebService::class.java)
}



