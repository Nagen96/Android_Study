package com.example.advancedstudycode

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_act16_shared_preference.*

class Act16_SharedPreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act16_shared_preference)


        // SharedPreference에 저장하는 방법
//        val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)

        // Mode
        // - MODE_PRIVATE: 생성한 application에서만 사용 가능
        // - MODE_WORLD_READABLE: 다른 application에서 사용 가능 -> 읽을 수만 있음
        // - MODE_WORLD_WRITEABLE: 다른 application에서 사용 가능 -> 기록도 가능
        // - MODE_MULTI_PROCESS: 이미 호출되어 사용중인지 체크
        // - MODE_APPEND: 기존 preference에 신규로 추가

//        val editor: SharedPreferences.Editor = sharedPreference.edit()
//        editor.putString("hello", "안녕하세요")
//        editor.commit()

        // name을 다르게 주는 것으로 구별가능
        // sp1 -> SharedPreference
        //      (Key, Value) -> ("hello", "안녕하세요")
        // sp2 -> SharedPreference
        //      (Key, Value) -> ("hello", "안녕하세요!!")

        // putString() 값을 저장
        save_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("hello", "안녕하세요")
            editor.putString("goodbye", "안녕히가세요")
            editor.commit()
        }

        // getString() 값을 받아옴
        load_btn.setOnClickListener {
            // SharedPreference에 값을 불러오는 방법
            val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello", "데이터 없음1")
            val value2 = sharedPreference.getString("goodbye", "데이터 없음2")
            Log.d("Key-Value", "Value : " + value1)
            Log.d("Key-Value", "Value : " + value2)
        }

        // remove() 특정 키값만 지워줌
        delete_btn.setOnClickListener {
            val sharedPreferences = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.remove("Hello")
            editor.commit()

        }

        // clear() 전부 지워줌
        delete_all_btn.setOnClickListener {
            val sharedPreferences = getSharedPreferences("sp1", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.commit()
        }
    }
}