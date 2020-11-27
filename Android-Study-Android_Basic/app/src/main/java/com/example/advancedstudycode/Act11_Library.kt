package com.example.advancedstudycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_act11_library.*

class Act11_Library : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act11_library)


        // Glide로 이미지 불러오기
        Glide.with(this@Act11_Library).load("https://picsum.photos/seed/picsum/200/300").centerCrop().into(glide)

        Glide.with(this@Act11_Library).load("https://picsum.photos/seed/picsum/200/300").into(glide2)

    }
}