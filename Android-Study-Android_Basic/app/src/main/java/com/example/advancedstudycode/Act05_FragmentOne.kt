package com.example.advancedstudycode

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.act05_fragment_one.*

class Act05_FragmentOne : Fragment() {


    interface OnDataPassListener {
        fun onDataPass(data: String?)
    }


    lateinit var dataPassListener: OnDataPassListener



    override fun onAttach(context: Context) {
        Log.d("life_cycle", "F onAttach")
        super.onAttach(context)




        dataPassListener = context as OnDataPassListener





    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onCreate")
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("life_cycle", "F onCreateView")


        // 프라그먼트가 인터페이스를 처음으로 그릴 때 호출된다.
        // inflater -> 뷰를 그려주는 역할
        // container -> 부모 뷰
        // inflate는 View를 리턴한다.
        return inflater.inflate(R.layout.act05_fragment_one, container, false)


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onViewCreated")
        super.onViewCreated(view, savedInstanceState)


        // onViewCreated()
        // Activity의 onCreate에서 했던 작업을 Fragment에선 여기서 한다
        pass.setOnClickListener {
            dataPassListener.onDataPass("Good Bye")
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onActivityCreated")
        super.onActivityCreated(savedInstanceState)


        // Act05_Fragment에서 Bundle data를 가져오기
        val data = arguments?.getString("hello")
        if (data != null) {
            Log.d("data", data)
        }


    }


    override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "F onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "F onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "F onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "F onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "F onDestroy")
    }


    override fun onDestroyView() {
        Log.d("life_cycle", "onDestroyView")
        super.onDestroyView()
    }


    override fun onDetach() {
        Log.d("life_cycle", "F onDetach")
        super.onDetach()
    }
}