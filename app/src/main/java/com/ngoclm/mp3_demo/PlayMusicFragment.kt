package com.ngoclm.mp3_demo

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ngoclm.mp3_demo.databinding.FragmentPlaySongBinding

class PlayMusicFragment : Fragment() {
    private lateinit var binding: FragmentPlaySongBinding
    private var countLove = 0
    private var statusShuffle = 0
    private var statusRepeat = 0
    private var statusPause = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPlaySongBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addEvents()
    }

    private fun addEvents() {
        with(binding) {
            btnLove.setOnClickListener() {
                countLove++
                if (countLove % 2 == 0) {
                    btnLove.setBackgroundResource(R.drawable.ic_heart)
                    Toast.makeText(
                        context, "Bạn đã bỏ thích bài hát này", Toast.LENGTH_SHORT).show()
                } else {
                    btnLove.setBackgroundResource(R.drawable.ic_heart1)
                    Toast.makeText(context, "Bạn đã thích bài hát này", Toast.LENGTH_SHORT).show()
                }
            }

            btnShuffle.setOnClickListener() {
                if (statusShuffle == 0) {
                    btnShuffle.setBackgroundResource(R.drawable.ic_shuffle)
                    statusShuffle = 1
                } else {
                    statusShuffle = 0
                    btnShuffle.setBackgroundResource(R.drawable.ic_shuffle1)
                }
            }

            btnRepeat.setOnClickListener() {
                if (statusRepeat == 0) {
                    btnRepeat.setBackgroundResource(R.drawable.ic_repeat)
                    statusRepeat = 1
                } else {
                    statusRepeat = 0
                    btnRepeat.setBackgroundResource(R.drawable.ic_repeat1)
                }
            }

            val animator = ObjectAnimator.ofFloat(imgSong, "rotation", 0f, 14400f)
            animator.duration = 270000

            btnPause.setOnClickListener() {
                if (animator.isPaused) {
                    animator.resume()
                    btnPause.setBackgroundResource(R.drawable.ic_pause)
                } else if (animator.isRunning) {
                    btnPause.setBackgroundResource(R.drawable.ic_play)
                    animator.pause()
                } else {
                    btnPause.setBackgroundResource(R.drawable.ic_pause)
                    animator.start()
                }
            }

        }
    }
}