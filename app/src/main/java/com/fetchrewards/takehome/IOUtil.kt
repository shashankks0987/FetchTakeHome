package com.fetchrewards.takehome

import com.fetchrewards.takehome.service.ItemService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//TODO Ideally should come using DI
object IOUtil {
    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://fetch-hiring.s3.amazonaws.com/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    val itemService = retrofit.create(ItemService::class.java)

}