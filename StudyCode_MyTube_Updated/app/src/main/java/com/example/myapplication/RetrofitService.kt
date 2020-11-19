package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {
    @GET("video/stream/")
    fun getYoutubeList(): Call<ArrayList<Youtube>>

    @FormUrlEncoded
    @POST("login/")
    fun requestLogin(
        @Field("userid") userID: String,
        @Field("userpw") userPW: String
    ): Call<User>
}