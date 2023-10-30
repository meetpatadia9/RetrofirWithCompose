package com.ipsmeet.retrofitwithcompose.e_commerce_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Product
import com.ipsmeet.retrofitwithcompose.ecommerce.layouts.CategoryList
import com.ipsmeet.retrofitwithcompose.ecommerce.layouts.ProductList
import com.ipsmeet.retrofitwithcompose.ui.theme.RetrofirWithComposeTheme

class EcommerceActivity : ComponentActivity() {

    lateinit var productList: List<Product>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RetrofirWithComposeTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen(ecommerceViewModel: EcommerceViewModel = viewModel()) {
    Column {
        CategoryList(categories = ecommerceViewModel.categories.value)
        ProductList(products = ecommerceViewModel.products.value)
    }
}