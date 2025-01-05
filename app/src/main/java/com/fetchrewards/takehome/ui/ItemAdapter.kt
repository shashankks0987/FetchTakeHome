package com.fetchrewards.takehome.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.fetchrewards.takehome.R
import com.fetchrewards.takehome.model.Item

class ItemAdapter(private val items: List<Item>): Adapter<ItemAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(parent: ViewGroup): ViewHolder(
        LayoutInflater.from(parent.context).inflate(
        R.layout.item_view_holder, parent,false)){
        private val itemName: TextView = itemView.findViewById(R.id.name)
        private val itemId: TextView = itemView.findViewById(R.id.id)

        fun onBind(item: Item){
            itemName.text = itemView.context.getString(R.string.name, item.name)
            itemId.text = itemView.context.getString(R.string.id, item.id.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(items[position])
    }
}