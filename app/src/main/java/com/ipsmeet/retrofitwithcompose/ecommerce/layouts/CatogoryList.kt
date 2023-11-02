package com.ipsmeet.retrofitwithcompose.ecommerce.layouts

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Categories

@Composable
fun CategoryList(context: Context, categories: List<Categories>) {
    LazyRow(Modifier.padding(start = 5.dp, top = 15.dp)) {
        items(categories) { categoryList ->
            for (category in categoryList) {
                CategoryView(
                    category = category,
                    onItemClick = {
                        // TODO()
                    }
                )
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