package com.example.advancedstudycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_act14_recycler_view.*
import java.util.ArrayList

class Act14_RecyclerView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act14_recycler_view)


        // 아이템 리스트 준비
        val carList = ArrayList<Act12_AddView.CarForList>()
        for (i in 0 until 50) {
            carList.add(Act12_AddView.CarForList("" + i + " 번째 자동차", "" + i + "순위 엔진"))
        }

        val adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this@Act14_RecyclerView))
        recycler_view.adapter = adapter


        // LayoutManager
//        recycler_view.layoutManager = LinearLayoutManager(this@Act14_RecyclerView)
        recycler_view.layoutManager = GridLayoutManager(this@Act14_RecyclerView, 2)


    }


    class RecyclerViewAdapter(
        val itemList: ArrayList<Act12_AddView.CarForList>,
        val inflater: LayoutInflater
    ) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val carName: TextView
            val carEngine: TextView

            init {
                carName = itemView.findViewById(R.id.car_name)
                carEngine = itemView.findViewById(R.id.car_engine)

                itemView.setOnClickListener {
                    // adapterPosition 변수에는 position에 대한 정보가 담겨있음
                    val position: Int = adapterPosition
                    val engineName = itemList.get(position).engine

                    Log.d("engine", engineName)
                }
            }
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.act12_item_view, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.carName.setText(itemList.get(position).name)
            holder.carEngine.setText(itemList.get(position).engine)
        }

        override fun getItemCount(): Int {
            return itemList.size
        }
    }
}