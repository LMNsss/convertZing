package com.ngoclm.mp3_demo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ngoclm.mp3_demo.OptionSong
import com.ngoclm.mp3_demo.databinding.ItemListOptionBinding

class ListOptionAdapter(var listOption: List<OptionSong>): RecyclerView.Adapter<ListOptionAdapter.ListOptionViewHolder>() {
    inner class ListOptionViewHolder(var binding: ItemListOptionBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListOptionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListOptionBinding.inflate(inflater, parent, false)
        return ListOptionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listOption.size
    }

    override fun onBindViewHolder(holder: ListOptionViewHolder, position: Int) {
        with(holder.binding){
            holder.binding.apply {
                imgOption.setImageResource(listOption[position].imageOption)
                tvOption.text = listOption[position].nameOption
            }
        }
    }

}