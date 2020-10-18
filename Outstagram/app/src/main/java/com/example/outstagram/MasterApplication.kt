package com.example.outstagram

import android.app.Application
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Application은 Activity보다 상위
class MasterApplication : Application() {

    lateinit var service: RetrofitService


    override fun onCreate() {
        super.onCreate()
    }


    fun creatRetrofit() {
        // Intercceptor: 통신이 나갈 때 가로챔 -> original 변수에 잡아둠
        val header = Interceptor {
            val original = it.request()
            // original에 잡아둔 통신을 개조함 -> header를 붙임
            val request = original.newBuilder()
                .header("Authorization", "").build()
            // 개조한 통신을 내보냄
            it.proceed(request)
        }


        val client = OkHttpClient.Builder().addInterceptor(header)
            .addNetworkInterceptor(StethoInterceptor()).build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        service = retrofit.create(RetrofitService::class.java)
    }


    fun checkIsLogin(): Boolean {
        return false
    }
}