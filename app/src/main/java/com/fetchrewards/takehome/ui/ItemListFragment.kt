package com.fetchrewards.takehome.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.fetchrewards.takehome.R
import androidx.fragment.app.activityViewModels

class ItemListFragment: Fragment(R.layout.item_list_fragment) {
    private val itemViewModel: ItemViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val groupRecyclerView: RecyclerView = view.findViewById(R.id.groupRecyclerView)

        itemViewModel.groupedItems.observe(viewLifecycleOwner){groupedItems ->
            groupRecyclerView.adapter = GroupAdapter(groupedItems)
        }

    }
}