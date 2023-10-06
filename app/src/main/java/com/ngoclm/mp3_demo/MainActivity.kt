package com.ngoclm.mp3_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.ngoclm.mp3_demo.adapter.FragmentPageAdapter
import com.ngoclm.mp3_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: FragmentPageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        tabLayout = binding.tbTabLayout
//        viewPager2 = binding.viewPager2
        adapter = FragmentPageAdapter(supportFragmentManager, lifecycle)
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_music_list_page))
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_song_page))
//        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_lyric_page))
//        viewPager2.adapter =adapter


    }
}