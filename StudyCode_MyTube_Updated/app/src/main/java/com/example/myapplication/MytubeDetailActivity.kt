package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.MediaController
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mytube_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MytubeDetailActivity : AppCompatActivity() {

    lateinit var commentEditText: EditText
    lateinit var sendBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mytube_detail)

        val url = intent.getStringExtra("video_url")
        video_view.setVideoPath(url)
        video_view.start()
        video_view.requestFocus()
        val mediaController = MediaController(this@MytubeDetailActivity)
        mediaController?.setAnchorView(video_view)
        video_view.setMediaController(mediaController)

        initView(this@MytubeDetailActivity)

        sendBtn.setOnClickListener {
            val comment = commentEditText.text.toString()
            if ((application as MasterApplication).checkIsLogin()) {
                val sp = getSharedPreferences("login_sp", Context.MODE_PRIVATE)
                val token = sp.getString("login_sp", "null")

                (application as MasterApplication).service.commentUpload(token!!, comment)
                    .enqueue(object : Callback<CommentOK> {
                        override fun onResponse(
                            call: Call<CommentOK>,
                            response: Response<CommentOK>
                        ) {
                            if (response.isSuccessful) {
                                Toast.makeText(
                                    this@MytubeDetailActivity,
                                    "덧글작성 완료.",
                                    Toast.LENGTH_LONG
                                )
                                    .show()
                            } else {
                                Toast.makeText(
                                    this@MytubeDetailActivity,
                                    "덧글작성 실패.",
                                    Toast.LENGTH_LONG
                                )
                                    .show()
                            }

                        }

                        override fun onFailure(call: Call<CommentOK>, t: Throwable) {
                            Toast.makeText(
                                this@MytubeDetailActivity,
                                "덧글작성 실패.",
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }
                    })
            } else {
                Toast.makeText(
                    this@MytubeDetailActivity,
                    "로그인이 필요합니다.",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
            commentEditText.text.clear()
        }
    }

    fun initView(activity: Activity) {
        commentEditText = activity.findViewById(R.id.comment_edit_text)
        sendBtn = activity.findViewById(R.id.send_btn)
    }
}
