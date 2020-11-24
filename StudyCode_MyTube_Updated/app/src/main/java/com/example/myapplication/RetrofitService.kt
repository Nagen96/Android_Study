package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService {
    @GET("video/stream/")
    fun getYoutubeList(): Call<ArrayList<Youtube>>

    @POST("login/")
    @FormUrlEncoded
    fun requestLogin(
        @Field("userid") userID: String,
        @Field("userpw") userPW: String
    ): Call<User>

    @POST("signup/")
    @FormUrlEncoded
    fun register(
        @Field("userid") userID: String,
        @Field("userpw") userPW: String,
        @Field("userpc") userPC: String
    ): Call<User>

    @POST("comment/upload/")
    @FormUrlEncoded
    fun commentUpload(
        @Field("token") token: String,
        @Field("comment_text") commentText: String
    ): Call<CommentOK>
}