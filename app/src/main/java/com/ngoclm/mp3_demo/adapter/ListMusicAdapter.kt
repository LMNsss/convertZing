package com.ngoclm.mp3_demo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ngoclm.mp3_demo.ButtonClickListener
import com.ngoclm.mp3_demo.Model.Song
import com.ngoclm.mp3_demo.databinding.ItemListMusicBinding
import kotlin.coroutines.coroutineContext

class ListMusicAdapter(
    private var ds: List<Song>,
    private var buttonClickListener: ButtonClickListener
) : RecyclerView.Adapter<ListMusicAdapter.ListSongViewHolder>() {
    inner class ListSongViewHolder(var binding: ItemListMusicBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSongViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListMusicBinding.inflate(inflater, parent, false)
        return ListSongViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return ds.size
    }

    override fun onBindViewHolder(holder: ListSongViewHolder, position: Int) {

        holder.binding.apply {
            Glide.with(holder.itemView.context)
                .load(ds[position].img)
                .into(imgSong)
            tvSongName.text = ds[position].songName
            tvSingerName.text = ds[position].singerName
            btnMenuSong.setOnClickListener() {
                buttonClickListener.onClickButton(it, position)
            }
            holder.itemView.setOnClickListener() {
                buttonClickListener.onClickItem(it, position)
            }
        }
    }
}