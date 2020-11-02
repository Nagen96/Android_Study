package com.example.advancedstudycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_act10_thread.*

class Act10_Thread : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act10_thread)


        val runnable: Runnable = object : Runnable {
            override fun run() {
                Log.d("thread-1", "Thread1 is made")
            }
        }

        val thread: Thread = Thread(runnable)


        button.setOnClickListener {
            thread.start()
        }


        // 무명스레드-1
        Thread(object : Runnable {
            override fun run() {
                Log.d("thread-1", "Thread2 is made")
            }
        }).start()


        // 무명스레드-2
        Thread(Runnable {
            Thread.sleep(2000)
            Log.d("thread-1", "Thread3 is made")

            // UI를 조작하는 스레드는 메인스레드에서만 가능하다.
            // runOnUiThread()는 할당된 작업을 메인스레드에 전달해준다.
            runOnUiThread() {
                button.setBackgroundColor(getColor(R.color.textview_color))
            }
        }).start()


    }
}