package com.ipsmeet.retrofitwithcompose.ecommerce.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ipsmeet.retrofitwithcompose.R
import com.ipsmeet.retrofitwithcompose.ecommerce.dataclass.Product
import com.ipsmeet.retrofitwithcompose.ui.theme.ForestGreen
import com.ipsmeet.retrofitwithcompose.ui.theme.RetrofitWithComposeTheme
import com.ipsmeet.retrofitwithcompose.ui.theme.Tangerine
import com.smarttoolfactory.ratingbar.RatingBar

@Composable
fun ViewProduct(product: Product) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        Box {
            if (product.images.size == 1) {
                AsyncImage(
                    model = product.images[0],
                    contentDescription = "Product images",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(350.dp)
                        .padding(horizontal = 5.dp, vertical = 5.dp)
                        .fillMaxWidth()
                )
            } else {
                LazyRow(
                    modifier = Modifier.height(300.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(product.images) {
                        AsyncImage(
                            model = it,
                            contentDescription = "Product images",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .width(300.dp)
                                .padding(horizontal = 6.dp, vertical = 9.dp)
                        )
                    }
                }   // lazy-row
            }
            Text(
                text = "${product.discountPercentage}%\nOFF",
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                lineHeight = 13.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(20.dp)
                    .shadow(elevation = 10.dp, shape = CircleShape)
                    .background(
                        color = MaterialTheme.colorScheme.error,
                        shape = CircleShape
                    )
                    .padding(12.dp),
                color = MaterialTheme.colorScheme.errorContainer
            )   // text - discountPercentage
        }   // box
        Column(
            modifier = Modifier.padding(top = 20.dp, start = 15.dp, end = 15.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = product.title,
                    fontSize = 21.sp,
                    lineHeight = 27.sp,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.weight(1.2f)
                )   // text - title
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp)
                ) {
                    Text(
                        text = "(${product.rating})",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.secondary
                    )   // text-rating-numbers
                    RatingBar(
                        rating = product.rating.toFloat(),
                        painterEmpty = painterResource(id = R.drawable.round_star_border_24),
                        painterFilled = painterResource(id = R.drawable.round_star_24),
                        onRatingChange = { product.rating.toFloat() },
                        modifier = Modifier.padding(start = 3.dp),
                        tintEmpty = Tangerine,
                        tintFilled = Tangerine
                    )   // rating-bar
                }   // row - text, ratingbar
            }   // row - title, ratingbar
            Text(
                text = product.description,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                modifier = Modifier.padding(top = 15.dp),
                color = MaterialTheme.colorScheme.outline
            )   // text - description
            Text(
                text = "₹ ${product.price}",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 25.dp),
                color = ForestGreen
            )   // text - price
            Text(
                text = "Available stock: ${product.stock}",
                modifier = Modifier.padding(top = 10.dp),
                fontWeight = FontWeight.W400
            )   // text - stock
        }   // column - title, description, ratingbar, price, stock
    }   // column - main
}

@Preview(showBackground = true)
@Composable
fun PreviewProductScreen() {
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
        ViewProduct(data)
    }
}