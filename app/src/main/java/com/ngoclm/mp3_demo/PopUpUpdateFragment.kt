package com.ngoclm.mp3_demo

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.ngoclm.mp3_demo.databinding.FragmentPopUpUpdateBinding


class PopUpUpdateFragment : DialogFragment() {
    private lateinit var binding: FragmentPopUpUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentPopUpUpdateBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addEvent()
    }

    fun addEvent(){
        val nameSong = arguments?.getString("name0fSong")
        val nameSinger = arguments?.getString("nameOfSinger")
        binding.etNameSong.setText(nameSong)
        binding.etNameSinger.setText(nameSinger)
        binding.btnUpdate.setOnClickListener(){
            val newNameSong = binding.etNameSong.toString()
            val newNameSinger = binding.etNameSinger.toString()

        }
    }
}