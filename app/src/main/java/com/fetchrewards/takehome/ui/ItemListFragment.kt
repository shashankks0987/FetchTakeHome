package com.fetchrewards.takehome.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.fetchrewards.takehome.R
import com.fetchrewards.takehome.repository.ItemRepository
import kotlinx.coroutines.launch

class ItemListFragment: Fragment(R.layout.item_list_fragment) {
    val repository by lazy {
        ItemRepository()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val groupRecyclerView: RecyclerView = view.findViewById(R.id.groupRecyclerView)

        lifecycleScope.launch {
            val groupedItems = repository.getGroupedItems()
            groupRecyclerView.adapter = GroupAdapter(groupedItems)
        }
    }
}