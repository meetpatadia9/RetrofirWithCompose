package com.ipsmeet.retrofitwithcompose.ecommerce.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Product


fun LazyListScope.productList(products: List<Product>, modifier: Modifier = Modifier) {
    val rows = (products.size + 1) / 2

    for (row in 0 until rows) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 10.dp, end = 10.dp)
            ) {
                val startIndex = row * 2
                val endIndex = minOf(startIndex + 2, products.size)

                for (i in startIndex until endIndex) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = modifier
                            .weight(1f)
                            .padding(10.dp)
                    ) {
                        ProductView(
                            img = products[i].thumbnail,
                            title = products[i].title,
                            description = products[i].description,
                            price = products[i].price
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewProductList() {
//    RetrofitWithComposeTheme {
//        ProductList()
//    }
//}