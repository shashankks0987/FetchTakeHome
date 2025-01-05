package com.fetchrewards.takehome.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.fetchrewards.takehome.IOUtil
import com.fetchrewards.takehome.R
import com.fetchrewards.takehome.model.Item
import kotlinx.coroutines.launch

class ItemListFragment: Fragment(R.layout.item_list_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stubData: List<Item> = listOf(
            Item(755, 2, ""),
            Item(203, 2, ""),
            Item(684, 1, "Item 684"),
            Item(276, 1, "Item 276"),
            Item(736, 3, null),
            Item(926, 4, null),
            Item(808, 4, "Item 808"),
            Item(599, 1, null),
            Item(424, 2, null)
        )
        val groupedItems = stubData.filter { !it.name.isNullOrEmpty() }.groupBy { it.listId }
        val groupRecyclerView: RecyclerView = view.findViewById(R.id.groupRecyclerView)
        groupRecyclerView.adapter = GroupAdapter(groupedItems)

        lifecycleScope.launch {
            val response = IOUtil.itemService.getItem()
            if (response.isSuccessful) {
                val item = response.body()
                Log.e("Fragment", item.toString())
            } else {
                Log.e("Fragment", "Error")
            }
        }
    }
}