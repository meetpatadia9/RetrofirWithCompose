package com.ipsmeet.retrofitwithcompose.ecommerce.layouts

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Categories

@Composable
fun CategoryList(categories: List<Categories>) {
    LazyRow(Modifier.padding(start = 5.dp, top = 10.dp)) {
        items(categories) {
            for (i in it) {
                CategoryView(category = i)
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewCategoryList() {
//    RetrofitWithComposeTheme {
//        CategoryList()
//    }
//}