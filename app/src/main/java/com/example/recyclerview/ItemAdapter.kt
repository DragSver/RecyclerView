package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ItemBinding


class ItemAdapter(var context: Context, var arrayList:ArrayList<Item>): RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val item = arrayList[position]
        holder.headerItem.text = item.name
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ItemHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var headerItem = binding.header
    }

    class ProductComparator : DiffUtil.ItemCallback<Item>(){
        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.name == newItem.name
        }
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }
}