package com.example.myapplication

import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mytube_detail.*

class MytubeDetailActivity : AppCompatActivity() {

    // This is origin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mytube_detail)

        val url = intent.getStringExtra("video_url")

        val mediaController = MediaController(this@MytubeDetailActivity)
        video_view.setVideoPath(url)
        video_view.requestFocus()
        video_view.start()
        mediaController.show()
    }

    // Updated in Later Version
/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mytube_detail)

        val url = intent.getStringExtra("video_url")
        video_view.setVideoPath(url)
        video_view.start()
        video_view.requestFocus()
        val mediaController = MediaController(this@MytubeDetailActivity)
        mediaController?.setAnchorView(video_view)
        video_view.setMediaController(mediaController)
    }*/
}
