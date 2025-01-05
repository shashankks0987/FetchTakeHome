package com.fetchrewards.takehome.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fetchrewards.takehome.model.Item
import com.fetchrewards.takehome.repository.ItemRepository
import kotlinx.coroutines.launch

class ItemViewModel: ViewModel() {
    private val repository by lazy {
        ItemRepository()
    }

    val groupedItems: LiveData<Map<Int, List<Item>>> by lazy {
        MutableLiveData<Map<Int, List<Item>>>().also { liveData ->
            viewModelScope.launch {
                val items = repository.getGroupedItems()
                liveData.postValue(items)
            }
        }
    }
}