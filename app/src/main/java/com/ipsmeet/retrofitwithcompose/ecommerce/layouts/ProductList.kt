package com.ipsmeet.retrofitwithcompose.ecommerce.layouts

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ipsmeet.retrofitwithcompose.e_commerce_app.ProductDetailActivity
import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Product

fun LazyListScope.productList(
    context: Context,
    products: List<Product>,
    modifier: Modifier = Modifier
) {
    val rows = (products.size + 1) / 2

    for (row in 0 until rows) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 10.dp, end = 10.dp),
            ) {
                val startIndex = row * 2
                val endIndex = minOf(startIndex + 2, products.size)

                for (i in startIndex until endIndex) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = modifier
                            .weight(1f)
                    ) {
                        ProductView(
                            product = products[i],
                            onItemClick = {
                                context.startActivity(
                                    Intent(context, ProductDetailActivity::class.java)
                                        .putExtra("productID", products[i].id.toString())
                                )
                            }
                        )
                    }   // column
                }
            }   // row
        }   // items
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewProductList() {
//    RetrofitWithComposeTheme {
//        ProductList()
//    }
//}