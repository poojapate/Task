package com.example.myapplication.Api

import com.example.myapplication.Model.LoginModel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @FormUrlEncoded
    @POST("userLogin")
    fun login(@Field("email") email: String, @Field("password") password: String): Call<LoginModel>
}