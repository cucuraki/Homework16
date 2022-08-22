package com.example.homework16.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.homework16.data.models.Data

class MyDiffUtil: DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Data, newItem: Data) = oldItem == newItem
}