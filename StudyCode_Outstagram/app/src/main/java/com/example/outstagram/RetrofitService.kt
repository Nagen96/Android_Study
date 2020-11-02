package com.example.outstagram

import com.example.myapplication.PersonFromServer
import com.example.myapplication.Post
import com.example.myapplication.User
import com.example.myapplication.Youtube
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface RetrofitService {

    @GET("json/students/")
    fun getStudentsList(): Call<ArrayList<PersonFromServer>>

    @POST("json/students/")
    fun createStudnet(
        @Body params: HashMap<String, Any>
    ): Call<PersonFromServer>

    @POST("json/students/")
    fun createStudentEasy(
        @Body person: PersonFromServer
    ): Call<PersonFromServer>

    @POST("user/signup")
    fun register(
        @Body register: Register
    ):Call<User>
}