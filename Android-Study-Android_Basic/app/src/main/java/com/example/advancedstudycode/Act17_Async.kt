package com.example.advancedstudycode

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_act17_async.*
import java.lang.Exception

@Suppress("DEPRECATION")
class Act17_Async : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act17_async)

        var task: BackgroundAsyncTask? = null
        var isTaskRunning = false

        start.setOnClickListener {
            if (isTaskRunning == false) {
                isTaskRunning = true
                task = BackgroundAsyncTask(progressbar, ment)
                task?.execute()
            }
        }

        stop.setOnClickListener {
            task?.cancel(true)
            isTaskRunning = false
        }


    }

    class BackgroundAsyncTask(
        val progressBar: ProgressBar,
        val progresText: TextView
    ) : AsyncTask<Int, Int, Int>() {
        // params -> doInBackground 에서 사용할 타입
        // progress -> onProgressUpdate 에서 사용하 타입
        // result -> onPostExcute 에서 사용할 타입

        var percent: Int = 0

        override fun onPreExecute() {
            percent = 0
            progressBar.setProgress(percent)
        }

        // vararg -> 변수가 여러개 올 수 있다.
        override fun doInBackground(vararg params: Int?): Int {
            while (isCancelled() == false) {
                percent++
                Log.d("async", "percent: " + percent)
                if (percent > 100) {
                    break
                } else {
                    publishProgress(percent)
                }
                try {
                    Thread.sleep(50)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            return percent
        }

        override fun onProgressUpdate(vararg values: Int?) {
            progressBar.setProgress(values[0] ?: 0)
            progresText.setText("퍼센트 : " + values[0])
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: Int?) {
            progresText.setText("작업이 완료되었습니다.")
        }

        override fun onCancelled() {
            progressBar.setProgress(0)
            progresText.setText("작업이 취소되었습니다.")
        }
    }
}