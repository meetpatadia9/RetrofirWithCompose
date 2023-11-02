package com.ipsmeet.retrofitwithcompose.e_commerce_app

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.ipsmeet.retrofitwithcompose.SuperDeclaration.DUMMY_JSON_BASE_URL
import com.ipsmeet.retrofitwithcompose.ecommerce.ViewProducts
import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Product
import com.ipsmeet.retrofitwithcompose.ecommerce.layouts.ViewProductScreen
import com.ipsmeet.retrofitwithcompose.ui.theme.RetrofitWithComposeTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductDetailActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val productID = intent.getStringExtra("productID").toString()
        Log.d("onCreate: productID", productID)

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("${DUMMY_JSON_BASE_URL}products/")
            .build()
            .create(ViewProducts::class.java)

        retrofitBuilder.viewProducts(productID)
            .enqueue(object : Callback<Product?> {
                override fun onResponse(call: Call<Product?>, response: Response<Product?>) {
                    setContent {
                        RetrofitWithComposeTheme {
                            ViewProductScreen(
                                product = response.body()!!,
                                onBackPress = { finish() }
                            )
                        }
                    }
                }

                override fun onFailure(call: Call<Product?>, t: Throwable) {
                    Log.e("onFailure: viewProduct", t.message.toString())
                }
            })
    }
}