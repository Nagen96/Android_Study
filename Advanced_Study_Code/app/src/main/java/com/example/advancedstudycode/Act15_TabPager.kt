package com.example.advancedstudycode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_act15_tab_pager2.*

class Act15_TabPager : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act15_tab_pager)

        // 레이아웃에 탭 추가
        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))

        val pagerAdapter = FragmentPagerAdapter(supportFragmentManager, 3)
        view_pager.adapter = pagerAdapter


        // TabLayout과 Pager 연동
        // 탭을 움직였을 때 페이저를 움직이게 해줌
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
        // 페이저를 움직였을 때 탭을 움직이게 해줌
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

    }


    class FragmentPagerAdapter(
        fragmentManager: FragmentManager,
        val tabCount: Int
    ) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getCount(): Int {
            return tabCount
        }

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> {
                    return Act15_Fragment1()
                }
                1 -> {
                    return Act15_Fragment2()
                }
                2 -> {
                    return Act15_Fragment3()
                }
                else -> return Act15_Fragment1()
            }
        }
    }
}