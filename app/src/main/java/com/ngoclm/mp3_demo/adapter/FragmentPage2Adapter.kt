package com.ngoclm.mp3_demo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ngoclm.mp3_demo.ListMusicFragment
import com.ngoclm.mp3_demo.LyricFragment
import com.ngoclm.mp3_demo.PlayMusicFragment
import com.ngoclm.mp3_demo.activity2.ChartFragment
import com.ngoclm.mp3_demo.activity2.DiscoveryFragment
import com.ngoclm.mp3_demo.activity2.LibraryFragment
import com.ngoclm.mp3_demo.activity2.ProfileFragment
import com.ngoclm.mp3_demo.activity2.RadioFragment

class FragmentPage2Adapter (fragmentManger: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManger, lifecycle){
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            1 -> LibraryFragment()
            2 -> DiscoveryFragment()
            3 -> ChartFragment()
            4 -> RadioFragment()
            else -> ProfileFragment()
        }
    }
}