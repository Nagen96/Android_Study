package com.example.advancedstudycode

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// Retrofit의 세부 URL을 관리할 인터페이스
// 왜 class가 아니고 interface인가? -> Retrofit 문서에 그렇게 하라고 지정되어 있음.
interface Act18e2_RetrofitService {

    // 어노테이션을 이용한 GET 방식으로 데이터를 받아옴
    // Retrofit 제작자가 지정한 방식으로 call<>같은 독특한 방법이 사용되지만 그냥 맞춰써야함
    @GET("json/students/")
    fun getStudentsList(): Call<ArrayList<Act18e1_PersonFromServer>>


    // POST 요청 (1) 방법
    @POST("json/students/")
    fun createStudent(
        @Body params: HashMap<String, Any>
    ): Call<Act18e1_PersonFromServer>


    // POST 요청 (2) 방법
    @POST("json/students/")
    fun createStudentEasy(
        @Body person: Act18e1_PersonFromServer
    ): Call<Act18e1_PersonFromServer>
}