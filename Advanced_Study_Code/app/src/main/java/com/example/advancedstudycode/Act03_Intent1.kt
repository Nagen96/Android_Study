package com.example.advancedstudycode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_act03_intent1.*

class Act03_Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act03_intent1)

        change_activity.setOnClickListener {
            // 지시하려는 명령어에 대한 정보를 담고 있는 액티비티를 Context로 할당 -> Act03_Intent1
            // this와 this@Act03_Intent1과 완전히 동일하지만 this만 넣을 경우 crash가 발생할 수 있음
            // 해당 명령을 수행할 액티비티를 두 번째 인자로 지정 -> Act03_Intent2

//            val intent = Intent(this@Act03_Intent1, Act03_Intent2::class.java)
//
//            // putExtra는 값을 전달하는 메소드
//            // Key, Value 방식으로 전달 -> Key와 Value를 쌍으로 만들어 저장한다. -> Dictionary
//            // name: number1&2가 Key, value: 1&2가 Value
//            intent.putExtra("number1", 1)
//            intent.putExtra("number2", 2)
//            startActivity(intent)

            val intent2 = Intent(this@Act03_Intent1, Act03_Intent2::class.java)

            // apply는 Intent의 작업을 묶어줌으로써 가독성을 훨씬 높혀줄 수 있다.
            intent2.apply {
                    this.putExtra("number1", 1)
                    this.putExtra("number2", 2)
            }
            // setResult로 저장한 값을 받기위해
            // startActivity 대신 startActivityForResult로 Intent 실행
            startActivityForResult(intent2, 200)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        // 자신이 보낸 코드인지 확인 -> startActivityForResult에서 보낸 requestCode: 200
        // 200 코드에서 result 값을 받아옴 (setResult로 저장된 값)
        if(requestCode == 200) {
            Log.d("number", "" + requestCode)
            Log.d("number", "" + resultCode)
            val result = data?.getIntExtra("result", 0)
            Log.d("number", "" + result)
        }

        super.onActivityResult(requestCode, resultCode, data)

    }
}