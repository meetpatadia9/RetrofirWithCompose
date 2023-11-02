package com.ipsmeet.retrofitwithcompose.ecommerce.layouts

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Product
import com.ipsmeet.retrofitwithcompose.ui.theme.RetrofitWithComposeTheme

@Composable
fun ProductView(
    product: Product,
    onItemClick: () -> Unit
) {
    Column(
        Modifier
            .width(150.dp)
            .clickable { onItemClick() },
        ) {
        AsyncImage(
            model = product.thumbnail,
            contentDescription = "Thumbnail",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(150.dp)
                .clip(MaterialTheme.shapes.medium)
        )   // async-image
        Column(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    end = 8.dp
                )
        ) {
            Text(
                text = product.title,
                fontSize = 15.sp,
                lineHeight = 18.sp,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(top = 9.dp),
                fontWeight = FontWeight.SemiBold
            )   // text - title
            Text(
                text = product.description,
                fontSize = 12.sp,
                lineHeight = 13.sp,
                modifier = Modifier.padding(top = 5.dp),
                color = MaterialTheme.colorScheme.secondary,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )   // text - description
            Text(
                text = "₹ ${product.price}",
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 5.dp),
                color = MaterialTheme.colorScheme.secondary
            )   // text - price
        }   // column
    }   // column
}

@Preview(showBackground = true)
@Composable
fun PreviewProductView() {
    val imgs = listOf(
        "https://i.dummyjson.com/data/products/2/1.jpg",
        "https://i.dummyjson.com/data/products/2/2.jpg",
        "https://i.dummyjson.com/data/products/2/3.jpg",
        "https://i.dummyjson.com/data/products/2/thumbnail.jpg"
    )
    val data = Product(
        id = 2,
        title = "iPhone X",
        description = "SIM-Free, Model A19211 6.5-inch Super Retina HD display with OLED technology A12 Bionic chip with ...",
        price = 899,
        discountPercentage = 17.94,
        rating = 4.44,
        stock = 34,
        brand = "Apple",
        category = "smartphone",
        thumbnail = "https://i.dummyjson.com/data/products/2/thumbnail.jpg",
        images = imgs
    )

    RetrofitWithComposeTheme {
        ProductView(product = data, onItemClick = {})
    }
}