package com.example.advancedstudycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Act07_lateinit : AppCompatActivity() {


    // lateinit 실습
    lateinit var lateCar: Car

    class Car(var number: Int) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act07_lateinit)


        // lateinit 실습
        // lateCar.number을 불러오기 전에 lateCar가 반드시 초기화되어야 한다
        lateCar = Car(10)
        Log.d("nubmer", "late number : " + lateCar.number)
        // lateCar = Car(10)
        // lateCar.number 보다 밑에 선언되면 에러


    }


}