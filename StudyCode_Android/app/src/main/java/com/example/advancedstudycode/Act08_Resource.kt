package com.example.advancedstudycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_act08_resource.*

class Act08_Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act08_resource)


        // strings.xml에 있는 hello를 불러온다
        // 방법 1
        val ment = resources.getString(R.string.hello)
        Log.d("resources", "ment : " + ment)


        // 방법 2
        val ment2 = getString(R.string.hello)
        Log.d("resources", "ment2 : " + ment2)


        // colors.xml에 있는 textview_color를 불러온다
        val color = getColor(R.color.textview_color)
        Log.d("resources", "color : " + color) // (color로그는 제대로 된 값이 출력되지 않는다)


        // 버튼의 색상을 getColor를 통해 지정
        button.setBackgroundColor(getColor(R.color.textview_color))

    }
}