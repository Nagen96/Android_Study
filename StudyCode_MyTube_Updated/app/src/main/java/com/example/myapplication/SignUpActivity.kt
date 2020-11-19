package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var user_id: EditText
    lateinit var user_pw: EditText
    lateinit var user_pc: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        cancel_button.setOnClickListener {
            finish()
        }

        fun initView(activity: Activity) {
            user_id = activity.findViewById(R.id.signup_id)
            user_pw = activity.findViewById(R.id.signup_pw)
            user_pc = activity.findViewById(R.id.signup_pc)
        }

        fun getUserID(): String {
            return user_id.text.toString()
        }

        fun getUserPW(): String {
            return user_pw.text.toString()
        }

        fun getUserPC(): String {
            return user_pc.text.toString()
        }
    }
}