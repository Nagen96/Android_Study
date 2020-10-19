package com.example.advancedstudycode

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.advancedstudycode.Act12_AddView.CarForList
import kotlinx.android.synthetic.main.activity_act13_list_view.*
import java.util.*

class Act13_ListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act13_list_view)

        // 아이템 리스트 준비
        val carList = ArrayList<CarForList>()
        for (i in 0 until 50) {
            carList.add(CarForList("" + i + " 번째 자동차", "" + i + "순위 엔진"))


            val adapter = ListViewAdapter(carList, LayoutInflater.from(this@Act13_ListView))
            listView.adapter = adapter


            listView.setOnItemClickListener { parent, view, position, id ->
                val carName = (adapter.getItem(position) as CarForList).name
                val carEngine = (adapter.getItem(position) as CarForList).engine

                // 스마트폰 화면 하단 토스트 텍스트 출력
                Toast.makeText(this@Act13_ListView, carName + " " + carEngine, Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    class ListViewAdapter(
        val carForList: ArrayList<CarForList>,
        val layoutInflater: LayoutInflater
    ) : BaseAdapter() {


        override fun getCount(): Int {
            // 그리고자 하는 아이템 리스트의 전체 갯수
            return carForList.size
        }

        override fun getItem(position: Int): Any {
            // 그리고자 하는 아이템 리스트의 하나(포지션에 해당하는)
            // position: 해당 아이템의 인덱스
            return carForList.get(position)
        }

        override fun getItemId(position: Int): Long {
            // 해당 포지션에 위치해 있는 아이템뷰의 아이디 설정
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            // ListView를 만드는 기본방법
//            val view = layoutInflater.inflate(R.layout.act12_item_view, null)
//            var carNameTextView = view.findViewById<TextView>(R.id.car_name)
//            var carEngineTextView = view.findViewById<TextView>(R.id.car_engine)
//
//            carNameTextView.setText(carForList.get(position).name)
//            carEngineTextView.setText(carForList.get(position).engine)
//            return view


            // ListView를 만드는 향상된 방법 -> ViewHolder 사용 (안드로이드 공식문서 권장)
            val view: View
            val holder: ViewHolder

            if(convertView == null) {
                Log.d("convert", "1")
                view = layoutInflater.inflate(R.layout.act12_item_view, null)
                holder = ViewHolder()

                holder.carName = view.findViewById(R.id.car_name)
                holder.carEngine = view.findViewById(R.id.car_engine)

                view.tag = holder

            } else {
                Log.d("convert", "2")
                holder = convertView.tag as ViewHolder
                view = convertView
            }

            holder.carName?.setText(carForList.get(position).name)
            holder.carEngine?.setText(carForList.get(position).engine)

            return view
        }
    }

    // ListView를 만드는 향상된 방법 -> ViewHolder 사용 (안드로이드 공식문서 권장)
    class ViewHolder {
        var carName: TextView? = null
        var carEngine: TextView? = null
    }
}