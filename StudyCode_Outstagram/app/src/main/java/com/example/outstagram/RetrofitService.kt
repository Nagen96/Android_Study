package com.example.outstagram

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @POST("user/signup")

    // 필드를 보내기 위한 어노테이션
    @FormUrlEncoded
    fun register(

        // 객체를 보낼 때
//        @Body register: Register

        // 필드를 보낼 때
        @Field("username") username: String,
        @Field("password1") password1: String,
        @Field("password2") password2: String,

        ): Call<User>

    @POST("user/login/")
    @FormUrlEncoded
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ):Call<User>

    @GET("instagram/post/list/all/")
    fun getAllPosts():Call<ArrayList<Post>>

    @Multipart
    @POST("instagram/post/")
    fun uploadPost(
        @Part image : MultipartBody.Part,
        @Part("content")requestBody : RequestBody
    ):Call<Post>

    @GET("instagram/post/list/")
    fun getUserPostList():Call<ArrayList<Post>>
}