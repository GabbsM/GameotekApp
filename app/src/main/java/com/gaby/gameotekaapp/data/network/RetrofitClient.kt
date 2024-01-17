package com.gaby.gameotekaapp.data.network

import com.gaby.gameotekaapp.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val retrofit: ApiRawg by lazy {

        Retrofit
            .Builder()
            .baseUrl("https://rawg.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRawg::class.java)
    }
}