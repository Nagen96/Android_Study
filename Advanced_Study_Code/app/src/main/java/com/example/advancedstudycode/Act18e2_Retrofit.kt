package com.example.advancedstudycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Act18e2_Retrofit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act18e2_retrofit)


        // Retrofit을 생성하는 방법
        val retrofit = Retrofit.Builder().baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(Act18e2_RetrofitService::class.java)


        // GET 요청
        // 통신을 큐에 넣어줌
        service.getStudentsList().enqueue(object : Callback<ArrayList<Act18e1_PersonFromServer>> {
            override fun onResponse(
                call: Call<ArrayList<Act18e1_PersonFromServer>>,
                response: Response<ArrayList<Act18e1_PersonFromServer>>
            ) {
                if (response.isSuccessful) {
                    // 통신으로부터 받아온 데이터를 리스트에 할당
                    val personList = response.body()
                    Log.d("retrofitt", "res: " + personList?.get(0)?.age)

                    val code = response.code()
                    Log.d("retrofitt", "code: " + code)

                    val header = response.headers()
                    Log.d("retrofitt", "header: " + header)
                }
            }

            override fun onFailure(call: Call<ArrayList<Act18e1_PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt", "ERROR")
            }
        })


        // POST 요청 (1) - HashMap 방법
        val params = HashMap<String, Any>()
        params.put("name", "포스트말론")
        params.put("age", 26)
        params.put("intro", "안녕하세요")
//        service.createStudent(params).enqueue(object : Callback<Act18e1_PersonFromServer> {
//            override fun onResponse(
//                call: Call<Act18e1_PersonFromServer>,
//                response: Response<Act18e1_PersonFromServer>
//            ) {
//                if (response.isSuccessful) {
//                    val person = response.body()
//                    Log.d("retrofitt", "name: " + person?.name)
//                }
//            }
//
//            override fun onFailure(call: Call<Act18e1_PersonFromServer>, t: Throwable) {}
//        })


        // POST 요청 (2) (더 쉽다) - PersonFromServer 객체 방법
        val person = Act18e1_PersonFromServer(name = "포스트말론", age = 26, intro = "안녕하세요")
        service.createStudentEasy(person).enqueue(object : Callback<Act18e1_PersonFromServer> {
            override fun onResponse(
                call: Call<Act18e1_PersonFromServer>,
                response: Response<Act18e1_PersonFromServer>
            ) {
                if (response.isSuccessful) {
                    val person = response.body()
                    Log.d("retrofitt", "name: " + person?.name)
                }
            }

            override fun onFailure(call: Call<Act18e1_PersonFromServer>, t: Throwable) {}
        })

        
    }
}