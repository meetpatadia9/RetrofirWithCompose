package com.ipsmeet.retrofitwithcompose.ecommerce

import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Categories
import retrofit2.Call
import retrofit2.http.GET

interface GetCategories {

    @GET("/products/categories")
    fun getCategories(): Call<Categories>

}