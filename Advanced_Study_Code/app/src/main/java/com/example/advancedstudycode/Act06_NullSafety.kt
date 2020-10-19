package com.example.advancedstudycode

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class Act06_NullSafety : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act06_null_safety)


        val number1: Int = 10
        val number2: Int? = null

        // val number3 = number2? + number1은 Syntax 에러
        val number3 = number2?.plus(number1)
        Log.d("number", "number3 : " + number3)


        // 삼항연산자 -> 엘비스 연산자 (?:)
        // number2가 Null이면 number4에 10을 대입한다
        val number4 = number2 ?: 10
        Log.d("number", "number4 : " + number4)


        // !!로 개발자가 Null이 아니라고 보장하기 때문에 Syntax 에러가 발생하지 않는다 (비권장)
//        val number5:Int = number2!! + 10
    }


    // 리턴타입에도 Null 여부조사를 해야한다
    fun plus(a: Int, b: Int?): Int {
        if (b != null) return a + b
        else return a
    }

    // 리턴타입에도 Null 여부조사를 해야한다 (2)
    fun plus2(a: Int, b: Int?): Int? {
        return b?.plus(a)
    }
}