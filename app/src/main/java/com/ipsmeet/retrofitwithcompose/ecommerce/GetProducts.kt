package com.ipsmeet.retrofitwithcompose.ecommerce

import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.EcommerceMainDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetProducts {

    @GET("/products")
    fun getProducts(
        @Query("limit") limit: Int
    ): Call<EcommerceMainDataClass>

}