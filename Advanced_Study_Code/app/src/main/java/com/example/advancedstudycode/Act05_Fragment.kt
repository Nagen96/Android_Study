package com.example.advancedstudycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_act05_fragment.*

class Act05_Fragment : AppCompatActivity(), Act05_FragmentOne.OnDataPassListener {


    
    // Fragment에서 Activity로 데이터 전달
    override fun onDataPass(data: String?) {
        Log.d("pass", "" + data)
    }

    


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act05_fragment)
        Log.d("life_cycle", "onCreate")


        // 프라그먼트 인스턴스 생성
        val fragmentOne: Act05_FragmentOne = Act05_FragmentOne()


        // 프라그먼트에 data를 넣어주는 방법 (Intent에선 putExtra를 사용했으나 프라그먼트엔 없다!)
        // - Bundle을 사용한다 -> Bundle에 data를 넣어주고 Fragment에 할당
        val bundle: Bundle = Bundle()
        bundle.putString("hello", "hello")
        fragmentOne.arguments = bundle



        button.setOnClickListener {
            // 프라그먼트를 동적으로 작동하는 방법
            // 프가르먼트 붙이는 방법: replace/add (거의 동일)
            val fragmentManager: FragmentManager = supportFragmentManager

            // Transaction
            // 작업의 단위 -> 시작과 끝이 있다
            val fragmentTransaction = fragmentManager.beginTransaction() // 트랜잭션의 시작
            fragmentTransaction.replace(R.id.container, fragmentOne) // 트랜잭션이 할 일: 프라그먼트 붙이기
            fragmentTransaction.commit() // 트랜잭션의 끝 선언

            // 트랜잭션을 끝내는 방법
            // commit    -> 시간 될 때 해 (좀 더 안정적)
            // commitnow -> 지금 당장해
        }


        button2.setOnClickListener {
            // 프라그먼트를 떼어내는 방법: remove/detach 하는 방법
            // remove는 다시 붙이기 가능
            // detach는 다시 붙이기 불가
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.detach(fragmentOne)
            fragmentTransaction.commit()
        }
    }





    override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "onDestroy")
    }
}