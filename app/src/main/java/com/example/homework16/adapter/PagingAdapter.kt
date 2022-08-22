package com.example.homework16.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework16.data.models.Data
import com.example.homework16.databinding.ItemLayoutBinding

class PagingAdapter : PagingDataAdapter<Data, PagingAdapter.DataViewHolder>(MyDiffUtil()) {

    inner class DataViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data?) {
            Glide.with(binding.root.context).load(data?.avatar ?: "").into(binding.root)
        }
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        ItemLayoutBinding.inflate(LayoutInflater.from(parent.context))
    )
}