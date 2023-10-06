package com.ngoclm.mp3_demo.activity2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.ngoclm.mp3_demo.R
import com.ngoclm.mp3_demo.adapter.FragmentPage2Adapter
import com.ngoclm.mp3_demo.adapter.FragmentPageAdapter
import com.ngoclm.mp3_demo.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: FragmentPage2Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        tabLayout = binding.tbTabLayout
        viewPager2 = binding.viewPager2
        adapter = FragmentPage2Adapter(supportFragmentManager, lifecycle)
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_music_list_page))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_song_page))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_chart))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_radio))
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_comment))
        viewPager2.adapter =adapter

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null){
                    viewPager2.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })
    }
}