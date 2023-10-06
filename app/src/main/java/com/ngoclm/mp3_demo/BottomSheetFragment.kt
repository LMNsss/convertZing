package com.ngoclm.mp3_demo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ngoclm.mp3_demo.adapter.ListOptionAdapter
import com.ngoclm.mp3_demo.databinding.FragmentBottomSheetBinding
import com.ngoclm.mp3_demo.databinding.ItemListOptionBinding

class BottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentBottomSheetBinding
    private val listOption = mutableListOf<OptionSong>()
    private lateinit var adapterListOption : ListOptionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentBottomSheetBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterListOption = ListOptionAdapter(listOption)
        binding.rvOptionOfSong.adapter = adapterListOption
        binding.rvOptionOfSong.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        createList()
    }

    fun createList(){
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
        listOption.add(OptionSong(R.drawable.ic_download, "Tải về"))
    }
}