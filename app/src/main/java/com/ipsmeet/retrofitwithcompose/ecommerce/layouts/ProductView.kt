package com.ipsmeet.retrofitwithcompose.ecommerce.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ipsmeet.retrofitwithcompose.ui.theme.RetrofirWithComposeTheme

@Composable
fun ProductView(img: String, title: String, description: String, price: Int) {
    Column(
        Modifier.width(120.dp)
    ) {
        AsyncImage(
            model = img,
            contentDescription = "Thumbnail",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(150.dp)
//                .size(
//                    height = 150.dp,
//                    width = 120.dp
//                )
                .clip(MaterialTheme.shapes.extraSmall)
        )   // image
        Column(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        ) {
            Text(
                text = title,
                fontSize = 15.sp
            )   // text - title
            Text(
                text = description,
                fontSize = 12.sp,
                lineHeight = 13.sp,
                modifier = Modifier.padding(top = 5.dp)
            )   // text - description
            Text(
                text = "₹ $price",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 5.dp)
            )   // text - price
        }   // column
    }   // column
}

@Preview(showBackground = true)
@Composable
fun PreviewProductView() {
    RetrofirWithComposeTheme {
        ProductView(
            "https://i.dummyjson.com/data/products/1/thumbnail.jpg",
            "Casual shirt",
            "Men regular fit shirt",
            378
        )
    }
}