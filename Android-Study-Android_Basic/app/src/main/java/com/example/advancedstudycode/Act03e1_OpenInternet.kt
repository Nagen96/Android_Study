package com.example.advancedstudycode

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_act03e1_open_internet.*

class Act03e1_OpenInternet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act03e1_open_internet)

        open.setOnClickListener {
            val address = address_edit_text.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(address))
            startActivity(intent)
        }

        // EditText 뷰의 변화를 감지하는 메소드 addTextChangedListener
        // TextWatcher 익명 함수를 사용
        address_edit_text.run {
            address_edit_text.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    Log.d("edit", "beforeTextChanged: " + s)
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    Log.d("edit", "onTextChanged: " + s)
                }

                override fun afterTextChanged(s: Editable?) {
                    Log.d("edit", "afterTextChanged: " + s)
                }
            })
        }
    }
}