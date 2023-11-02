package com.ipsmeet.retrofitwithcompose.ecommerce

import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ViewProducts {
    @GET
    fun viewProducts(@Url productID: String): Call<Product>
}
