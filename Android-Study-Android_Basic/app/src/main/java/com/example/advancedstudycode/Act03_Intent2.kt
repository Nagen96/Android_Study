package com.example.advancedstudycode

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_act03_intent2.*

class Act03_Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act03_intent2)

        result.setOnClickListener {

            // intent로 보내진 값을 받아옴
            // null이 발생하지 않도록 defaultValue를 지정
            val number1 = intent.getIntExtra("number1", 0)
            val number2 = intent.getIntExtra("number2", 0)

            Log.d("number", "" + number1)
            Log.d("number", "" + number2)

            val result = number1 + number2



            // resultIntent라는 Intent를 만들고
            // resultIntent에 putExtra로 result 값을 넣어줌
            val resultIntent = Intent()
            resultIntent.putExtra("result", result)

            // 이 Intent의 결과값 (더하기 연산)을 보내기 위해 setResult에 저장
            // Activity.RESULT_OK는 -1이라는 상수
            setResult(Activity.RESULT_OK, resultIntent)


            finish() // -> Activity 종료
            // Intent는 스택 밑에부터 점점 쌓여가는 원리
            // 스택                        스택
            // Intent2 -> Intent2 종료
            // Intent1                  -> Intent1
        }
    }
}