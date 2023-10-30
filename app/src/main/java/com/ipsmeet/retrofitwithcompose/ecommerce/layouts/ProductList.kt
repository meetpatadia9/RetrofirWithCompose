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
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = Modifier.padding(15.dp),
        state = rememberLazyGridState()
    ) {
        items(products) {
            ProductView(
                img = it.thumbnail,
                title = it.title,
                description = it.description,
                price = it.price
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewProductList() {
//    RetrofirWithComposeTheme {
//        ProductList()
//    }
//}