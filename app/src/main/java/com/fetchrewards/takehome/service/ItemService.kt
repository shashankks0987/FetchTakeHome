package com.fetchrewards.takehome.service

import com.fetchrewards.takehome.model.Item
import retrofit2.Response
import retrofit2.http.GET

interface ItemService {
        @GET("hiring.json")
        suspend fun getItem(): Response<List<Item>>
    }