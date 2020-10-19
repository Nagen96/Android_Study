package com.example.advancedstudycode

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_act03_intent1.*

class Act03_Intent3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act03_intent3)

        change_activity.setOnClickListener {

            // 암시적 인텐트 -> 할 수 있는 대상에 요청
            // 해당 uri를 보여주는 인텐트
            // uri을 열 수 있는 앱은 다양하다. (ex. 인터넷앱, 네이버앱, 크롬앱 etc...)
            // 이렇게 할 수 있는 대상들에게 요청한다.
            // 네이버앱을 이용할지 크롬앱을 이용할지는 사용자가 결정
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(intent)
        }
    }
}