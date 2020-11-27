package com.example.advancedstudycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_act12e2_phone_book_detail.*

class Act12e2_PhoneBookDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act12e2_phone_book_detail)


        getPersonInfoAndDraw()

        back.setOnClickListener {
            // 뒤로가기 입력을 실행하는 함수
            onBackPressed()
        }
    }


    fun getPersonInfoAndDraw() {
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")


        person_detail_name.setText(name)
        person_detail_number.setText(number)
    }
}