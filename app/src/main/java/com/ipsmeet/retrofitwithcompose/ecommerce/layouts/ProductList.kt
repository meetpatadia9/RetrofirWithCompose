package com.ipsmeet.retrofitwithcompose.ecommerce.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Product

@Composable
fun ProductList(products: List<Product>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        verticalArrangement = Arrangement.spacedBy(25.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(top = 15.dp, start = 10.dp, end = 10.dp),
        state = rememberLazyGridState()
    ) {
        items(products) {
            ProductView(
                img = it.thumbnail,
                title = it.title,
                description = it.description,
                price = it.price
            )
        }   // items
    }   // lazy-vertical-grid
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewProductList() {
//    RetrofitWithComposeTheme {
//        ProductList()
//    }
//}