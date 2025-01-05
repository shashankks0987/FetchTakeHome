package com.fetchrewards.takehome.repository

import android.util.Log
import com.fetchrewards.takehome.IOUtil
import com.fetchrewards.takehome.model.Item

class ItemRepository {
    private val TAG = "ItemRepository"
    private suspend fun getItems(): List<Item>?{
        val response = IOUtil.itemService.getItem()
        if (response.isSuccessful) {
            return response.body()
        } else {
            Log.e(TAG, "Error in fetching API ${response.errorBody()}")
            return null
        }
    }

    suspend fun getGroupedItems():  Map<Int, List<Item>> {
        val items = getItems()
        return items?.filter { !it.name.isNullOrEmpty() }
            ?.groupBy { it.listId } ?: emptyMap()
    }
}