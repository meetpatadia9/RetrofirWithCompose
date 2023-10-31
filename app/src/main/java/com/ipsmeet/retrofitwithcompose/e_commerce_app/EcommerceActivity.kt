package com.ipsmeet.retrofitwithcompose.e_commerce_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ipsmeet.retrofitwithcompose.ecommerce.layouts.HomeScreen
import com.ipsmeet.retrofitwithcompose.ui.theme.RetrofitWithComposeTheme

class EcommerceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RetrofitWithComposeTheme {
                HomeScreen()
            }
        }
    }
}