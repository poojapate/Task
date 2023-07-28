package com.example.myapplication.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(" https://mmfinfotech.co/machine_test/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api:ApiInterface by lazy {
            retrofit.create(ApiInterface::class.java)
        }
    }
}