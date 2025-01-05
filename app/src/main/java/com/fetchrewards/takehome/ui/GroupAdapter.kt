package com.fetchrewards.takehome.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.fetchrewards.takehome.R
import com.fetchrewards.takehome.model.Item

class GroupAdapter(private val groupedItems: Map<Int, List<Item>>): Adapter<GroupAdapter.GroupViewHolder>() {
    inner class GroupViewHolder(parent: ViewGroup): ViewHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.group_view_holder, parent,false)){
        private val listIdTextView: TextView = itemView.findViewById(R.id.groupName)
        private val itemRecyclerView: RecyclerView = itemView.findViewById(R.id.itemRecyclerView)

        fun onBind(group: Map.Entry<Int, List<Item>>) {
            listIdTextView.text = "List ID: ${group.key}"
            val itemAdapter = ItemAdapter(group.value)
            itemRecyclerView.adapter = itemAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        return GroupViewHolder(parent)
    }

    override fun getItemCount(): Int {
        return groupedItems.size
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val group = groupedItems.entries.toList()[position]
        holder.onBind(group)
    }
}