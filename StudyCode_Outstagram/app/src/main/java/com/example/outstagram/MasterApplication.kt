package com.example.outstagram

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
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

        Stetho.initializeWithDefaults(this)
        creatRetrofit()
        //chrome://inspect/#devices
    }


    fun creatRetrofit() {
        // Intercceptor: 통신이 나갈 때 가로챔 -> original 변수에 잡아둠
        val header = Interceptor {
            val original = it.request()

            // 로그인 검사 (토큰 값의 유무로 판별)
            if (checkIsLogin()) {

                // null이 아닌 경우 let부분 이하를 실행한다.
                // token은 getUserToken()의 리턴 값
                    // original에 잡아둔 통신을 개조함 -> header를 붙임
                    // POSTMAN의 서버주가 설정한 통신방식에 따른다. -> "Authorization", "token " + token
                getUserToken()?.let { token ->
                    val request = original.newBuilder()
                        .header("Authorization", "token " + token)
                        .build()
                    // 개조한 통신을 내보냄
                    it.proceed(request)
                }

            } else {
                it.proceed(original)
            }
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

    // 로그인 검사 (토큰 값의 유무로 판별)
    fun checkIsLogin(): Boolean {
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null")
        if (token != "null") return true
        else return false
}

    // 토큰 리턴
    fun getUserToken(): String? {
        val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null")
        if (token == "null") return null
        else return token
    }
}