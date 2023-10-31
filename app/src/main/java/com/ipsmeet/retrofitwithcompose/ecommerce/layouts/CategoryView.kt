package com.ipsmeet.retrofitwithcompose.ecommerce.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CategoryView(category: String) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        modifier = Modifier.padding(horizontal = 5.dp)
    ) {
        Text(
            text = category,
            modifier = Modifier
                .padding(2.dp)
                .background(color = MaterialTheme.colorScheme.surfaceVariant)
                .padding(5.dp)
        )
    }
}

//@Preview
//@Composable
//fun PreviewCategoryView() {
//    RetrofitWithComposeTheme {
//        CategoryView()
//    }
//}