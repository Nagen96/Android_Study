package com.example.advancedstudycode

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatViewInflater
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_act18_network.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

@Suppress("DEPRECATION")
class Act18_Network : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act18_network)

        NetworkTask(
            recycler_person,
            LayoutInflater.from(this@Act18_Network)
        ).execute()
    }


    class NetworkTask(
        val recyclerView: RecyclerView,
        val inflater: LayoutInflater
    ) : AsyncTask<Any?, Any?, Array<Act18e1_PersonFromServer>?>() {

        override fun onPostExecute(result: Array<Act18e1_PersonFromServer>?) {
            // UI 쓰레드에 접근 가능 -> 여기서 뷰를 그린다.
            val adapter = PersonAdapter(result!!, inflater)
            recyclerView.adapter = adapter
            super.onPostExecute(result)
        }

        override fun doInBackground(vararg params: Any?): Array<Act18e1_PersonFromServer>? {
            val urlString: String = "http://mellowcode.org/json/students/"
            val url: URL = URL(urlString)
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection

            connection.requestMethod = "GET"
            connection.setRequestProperty("Content-Type", "application/json")

            var buffer = ""
            if (connection.responseCode == HttpURLConnection.HTTP_OK) {
                val reader = BufferedReader(
                    InputStreamReader(
                        connection.inputStream,
                        "UTF-8"
                    )
                )
                buffer = reader.readLine()
            }

            // 데이터를 배열 형식으로 받아옴
            val data = Gson().fromJson(buffer, Array<Act18e1_PersonFromServer>::class.java)
            return data
        }
    }


    // RecyclerView 제작
    class PersonAdapter(
        val personList: Array<Act18e1_PersonFromServer>,
        val inflater: LayoutInflater
    ) : RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val name: TextView
            val age: TextView
            val intro: TextView

            init {
                name = itemView.findViewById(R.id.person_name)
                age = itemView.findViewById(R.id.person_age)
                intro = itemView.findViewById(R.id.person_ment)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.act18_person_list_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.name.setText(personList.get(position).name ?: "")
            holder.age.setText(personList.get(position).age.toString())
            holder.intro.setText(personList.get(position).intro ?: "")
        }

        override fun getItemCount(): Int {
            return personList.size
        }
    }
}