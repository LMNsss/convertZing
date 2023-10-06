package com.ngoclm.mp3_demo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ngoclm.mp3_demo.ListMusicFragment
import com.ngoclm.mp3_demo.LyricFragment
import com.ngoclm.mp3_demo.PlayMusicFragment

class FragmentPageAdapter(fragmentManger: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManger, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0){
            ListMusicFragment()
        }
        else{
            if (position == 1){
                PlayMusicFragment()
            }
            else {
                LyricFragment()
            }
        }
    }
}