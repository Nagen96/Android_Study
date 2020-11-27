package com.example.djangoretrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var retrofit = Retrofit.Builder().baseUrl("http://220.94.178.76:8080")
            .addConverterFactory(GsonConverterFactory.create()).build()

        var loginService = retrofit.create(LoginService::class.java)

        sign_in.setOnClickListener {
            var userID = user_id.text.toString()
            var userPW = user_pw.text.toString()

            loginService.requestLogin(userID, userPW).enqueue(object : Callback<Login> {
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    var login = response.body()
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("Response.")
                    dialog.setMessage("userID: $userID userPW: $userPW body: $login")
                    dialog.show()
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("Failure.")
                    dialog.setMessage("Failure.")
                    dialog.show()
                }
            })
        }
    }
}