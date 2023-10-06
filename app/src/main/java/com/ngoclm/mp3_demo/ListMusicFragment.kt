package com.ngoclm.mp3_demo

import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ngoclm.mp3_demo.Model.Song
import com.ngoclm.mp3_demo.ViewModel.ViewModelListen
import com.ngoclm.mp3_demo.adapter.ListMusicAdapter
import com.ngoclm.mp3_demo.databinding.DialogAddBinding
import com.ngoclm.mp3_demo.databinding.DialogDeleteBinding
import com.ngoclm.mp3_demo.databinding.FragmentListMusicBinding


class ListMusicFragment : Fragment() {
    private lateinit var binding: FragmentListMusicBinding
    private lateinit var dialog: AlertDialog
    private val ds = mutableListOf<Song>()
    private lateinit var adapter: ListMusicAdapter
    private val myViewModel by viewModels<ViewModelListen>()

    private var countSort: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentListMusicBinding.inflate(layoutInflater)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
        initControls()
        initEvents()
    }

    private fun initEvents() {
        TODO("Not yet implemented")
    }

    private fun initControls() {
        TODO("Not yet implemented")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ListMusicAdapter(ds, object : ButtonClickListener {
            override fun onClickButton(view: View, pos: Int) {
                super.onClickButton(view, pos)
                val popupMenu = PopupMenu(requireContext(), view)
                popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)
                popupMenu.setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.btn_option_update -> {
                            val showPopUp = PopUpUpdateFragment()
                            val bundle = Bundle()
                            bundle.putString("name0fSong", ds[pos].songName)
                            bundle.putString("nameOfSinger", ds[pos].singerName)
                            showPopUp.arguments = bundle
                            showPopUp.show(childFragmentManager, showPopUp.tag)
                            true
                        }

                        R.id.btn_option_delete -> {
                            dialogDeleteEvent(pos)
                            true
                        }

                        else -> false
                    }
                }
                popupMenu.show()
            }

            override fun onClickItem(view: View, pos: Int) {
                super.onClickItem(view, pos)

            }
        })
        binding.rvListMusic.adapter = adapter
        binding.rvListMusic.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        addListSong()
        addEvents()
    }


//    fun addListSong(){
//        ds.add(Song(R.drawable.img_song_background, "h Đếm Ngày Xa Em", "Only C, Lou Hoàng"))
//        ds.add(Song(R.drawable.img_song_background, "a Đếm Ngày Xa Em 1", "Only C, Lou Hoàng 1 "))
//        ds.add(Song(R.drawable.img_song_background, "a Đếm Ngày Xa Em", "Only C, Lou Hoàng 2"))
//        ds.add(Song(R.drawable.img_song_background, "a Đếm Ngày Xa Em 2", "Only C, Lou Hoàng"))
//        ds.add(Song(R.drawable.img_song_background, "n Đếm Ngày Xa Em", "Only C, Lou Hoàng"))
//        ds.add(Song(R.drawable.img_song_background, "d Đếm Ngày Xa Em", "Only C, Lou Hoàng"))
//        ds.add(Song(R.drawable.img_song_background, "m Đếm Ngày Xa Em", "Only C, Lou Hoàng"))
//        ds.add(Song(R.drawable.img_song_background, "f Đếm Ngày Xa Em", "Only C, Lou Hoàng"))
//        ds.add(Song(R.drawable.img_song_background, "g Đếm Ngày Xa Em", "Only C, Lou Hoàng"))
//        ds.add(Song(R.drawable.img_song_background, "e Đếm Ngày Xa Em", "Only C, Lou Hoàng"))
//        ds.add(Song(R.drawable.img_song_background, "j Đếm Ngày Xa Em", "Only C, Lou Hoàng"))
//        ds.add(Song(R.drawable.img_song_background, "k Đếm Ngày Xa Em", "Only C, Lou Hoàng"))
//        ds.add(Song(R.drawable.img_song_background, "l Đếm Ngày Xa Em", "Only C, Lou Hoàng"))
//        ds.add(Song(R.drawable.img_song_background, "o Đếm Ngày Xa Em", "Only C, Lou Hoàng"))
//        ds.add(Song(R.drawable.img_song_background, "p Đếm Ngày Xa Em", "Only C, Lou Hoàng"))
//    }

    fun addEvents() {
        binding.btnSort.setOnClickListener() {
            countSort++
            if (countSort % 2 == 0) {
                binding.btnSort.setBackgroundResource(R.drawable.ic_sort_down)
                ds.sortBy { it.songName }
                adapter.notifyDataSetChanged()
            } else {
                binding.btnSort.setBackgroundResource(R.drawable.ic_sort_up)
                ds.sortByDescending { it.songName }
                adapter.notifyDataSetChanged()
            }
        }
        binding.btnPlusNewSong.setOnClickListener() {
            dialogAddEvent()
        }

        binding.btnMenu.setOnClickListener() {
            showBottomSheet()
        }

        binding.btnDown.setOnClickListener() {
//            val navController = Navigation.findNavController(requireActivity(),R.id.listMusicFragment2)
//            navController.navigate(R.id.playMusicFragment)
//            val intent = Intent(activity, MainActivity2::class.java)
//            startActivity(intent)
            findNavController().navigate(R.id.action_listMusicFragment2_to_playMusicFragment)
        }
        val originalText = binding.etSearch.text.toString()
        binding.etSearch.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                // Người dùng đã click ra ngoài EditText, đặt lại text ban đầu
                binding.etSearch.setText(originalText)
            }
        }
    }

    private fun dialogAddEvent() {
        val dialogBinding = DialogAddBinding.inflate(LayoutInflater.from(context))
        val build = AlertDialog.Builder(context)
        build.setView(dialogBinding.root)
        dialog = build.create()
        dialog.show()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogBinding.btnAdd.setOnClickListener() {
            val inputSongName = dialogBinding.tvInputNameSong.text.toString()
            val inputSingerName = dialogBinding.tvInputNameSinger.text.toString()
//            addNew(inputSongName,inputSingerName)
        }

    }

    private fun dialogDeleteEvent(position: Int) {
        val dialogDeleteBinding = DialogDeleteBinding.inflate(LayoutInflater.from(context))
        val build = AlertDialog.Builder(context)
        build.setView(dialogDeleteBinding.root)
        dialog = build.create()
        dialog.show()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogDeleteBinding.btnAccept.setOnClickListener() {
            ds.removeAt(position)
            adapter.notifyDataSetChanged()
            sortList(position)
            dialog.dismiss()
        }
        dialogDeleteBinding.btnCancel.setOnClickListener() {
            dialog.dismiss()
        }
    }

    private fun sortList(position: Int) {
        if (countSort % 2 == 0) {
            ds.sortBy { it.songName }
            adapter.notifyItemChanged(position)
        } else {
            ds.sortByDescending { it.songName }
            adapter.notifyItemChanged(position)
        }
    }

//    private fun addNew(inputSong : String, inputSinger : String ) {
//        if (inputSong == ""|| inputSinger == ""){
//            Toast.makeText(context, "Bạn chưa nhập đủ thông tin", Toast.LENGTH_SHORT).show()
//        }
//        else{
//            ds.add(Song(R.drawable.img_song_background,inputSong,inputSinger))
//            Toast.makeText(context,"Thêm bài hát thành công", Toast.LENGTH_SHORT).show()
//            if (countSort % 2 == 0 ){
//                ds.sortBy { it.songName }
//                adapter.notifyDataSetChanged()
//            }
//            else{
//                ds.sortByDescending { it.songName }
//                adapter.notifyDataSetChanged()
//            }
//            dialog.dismiss()
//        }
//
//    }


    private fun update() {

    }

    private fun showBottomSheet() {
        val dialogBottomSheet = BottomSheetFragment()
        dialogBottomSheet.show(parentFragmentManager, tag)
    }


}