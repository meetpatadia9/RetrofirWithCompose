package com.ipsmeet.retrofitwithcompose.ecommerce.activity

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.ipsmeet.retrofitwithcompose.SuperDeclaration
import com.ipsmeet.retrofitwithcompose.ecommerce.GetCategories
import com.ipsmeet.retrofitwithcompose.ecommerce.GetProducts
import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Categories
import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.EcommerceMainDataClass
import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EcommerceViewModel : ViewModel() {


    private val _categories = mutableStateOf<List<Categories>>(emptyList())
    val categories: State<List<Categories>> = _categories

    private val _products = mutableStateOf<List<Product>>(emptyList())
    val products: State<List<Product>> = _products

    init {
        fetchCategories()
        fetchProducts()
    }

    private fun fetchCategories() {
        val categories = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(SuperDeclaration.DUMMY_JSON_BASE_URL)
            .build()
            .create(GetCategories::class.java)

        categories.getCategories()
            .enqueue(object : Callback<Categories?> {
                override fun onResponse(call: Call<Categories?>, response: Response<Categories?>) {
                    Log.d("onResponse: categories", response.body().toString())
                    val list = arrayListOf<Categories>()
                    list.add(response.body()!!)
                    _categories.value = list
                }

                override fun onFailure(call: Call<Categories?>, t: Throwable) {
                    Log.e("onFailure: products", t.message.toString())
                }
            })
    }

    private fun fetchProducts() {
        val products = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(SuperDeclaration.DUMMY_JSON_BASE_URL)
            .build()
            .create(GetProducts::class.java)

        products.getProducts(100)
            .enqueue(object : Callback<EcommerceMainDataClass?> {
                override fun onResponse(
                    call: Call<EcommerceMainDataClass?>,
                    response: Response<EcommerceMainDataClass?>
                ) {
                    _products.value = response.body()!!.products
                }

                override fun onFailure(call: Call<EcommerceMainDataClass?>, t: Throwable) {
                    Log.e("onFailure: products", t.message.toString())
                }
            })
    }

}

