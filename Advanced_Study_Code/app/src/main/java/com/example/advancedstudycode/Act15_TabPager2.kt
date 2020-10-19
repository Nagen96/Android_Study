package com.example.advancedstudycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_act15_tab_pager.*
import kotlinx.android.synthetic.main.activity_act15_tab_pager.tab_layout
import kotlinx.android.synthetic.main.activity_act15_tab_pager.view_pager
import kotlinx.android.synthetic.main.activity_act15_tab_pager2.*

class Act15_TabPager2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act15_tab_pager2)


        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))

        val adapter = ThreePageAdapter(LayoutInflater.from(this@Act15_TabPager2))
        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    view_pager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }


    class ThreePageAdapter(
        val layoutInflater: LayoutInflater
    ) : PagerAdapter() {

        // 만들 페이지의 개수 삽입
        override fun getCount(): Int {
            return 3
        }

        // 자바에서 object는 키워드이기 때문에 코틀린에서 변수명으로 쓰기위해 `object`로 쓴다
        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object` as View
        }

        // 파괴할 view를 지정하는 메소드
        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

        // 실질적으로 view가 그려지는 메소드
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            when (position) {
                0 -> {
                    val view = layoutInflater.inflate(R.layout.act15_fragment_one, container, false)
                    container.addView(view)
                    return view
                }
                1 -> {
                    val view = layoutInflater.inflate(R.layout.act15_fragment_two, container, false)
                    container.addView(view)
                    return view
                }
                2 -> {
                    val view =
                        layoutInflater.inflate(R.layout.act15_fragment_three, container, false)
                    container.addView(view)
                    return view
                }
                else -> {
                    val view = layoutInflater.inflate(R.layout.act15_fragment_one, container, false)
                    container.addView(view)
                    return view
                }
            }
        }
    }
}