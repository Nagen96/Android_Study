package com.example.advancedstudycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_act02_listener.*

class Act02_Listener : AppCompatActivity() {

    var number = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act02_listener)

        // 뷰를 activity로 가져오는 방법
        // 1> 직접 찾아서 가져온다
//        val textView : TextView = findViewById(R.id.hello)
        // 2> xml을 import해서 가져온다
//        hello.


        // 익명함수
        // 1 -> 람다 방식
        hello.setOnClickListener {
            Log.d("click", "Click!!")
        } // 클릭시 "Click!!" 로그 메시지 출력

        // 2 -> 익명 함수 방식
        hello.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click", "Click!!")
            }
        })

        // 3 -> 이름이 필요한 경우(click)
        val click = object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click", "Click!!")

                // 클릭할 경우 텍스트를 안녕하세요로 변경
                hello.setText("안녕하세요")

                // 클릭할 경우 이미지를 boy로 변경
                // R은 Resource의 약자
                image.setImageResource(R.drawable.boy)

                // 클릭할 경우 number에 10을 더하고 Log 메시지 출력
                number += 10
                Log.d("number", "" + number)
            }
        }

        hello.setOnClickListener(click)

        // 뷰를 조작 하는 함수들
        // 1> setText
        // 2> setImageResource

    }
}