package com.gaby.gameotekaapp.data.network

import com.gaby.gameotekaapp.data.network.rawg.ApiRawg
import com.gaby.gameotekaapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val apiRawg: ApiRawg by lazy {

        Retrofit
            .Builder()
            .baseUrl(Constants.RAWG_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRawg::class.java)
    }
}