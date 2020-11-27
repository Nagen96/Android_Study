package com.example.advancedstudycode

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Act09_Context : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act09_context)



        val context: Context = this
        val applicationContext: Context = getApplicationContext()
    }
}