package com.ipsmeet.retrofitwithcompose.ecommerce.layouts

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Categories

@Composable
fun CategoryList(categories: List<Categories>) {
    Row {
        Spacer((Modifier.width(10.dp) ))
        LazyRow(Modifier.padding(top = 5.dp)) {
            items(categories) {
                for (i in it) {
                    CategoryView(category = i)
                }
            }
        }
        Spacer((Modifier.width(10.dp) ))
    }
}