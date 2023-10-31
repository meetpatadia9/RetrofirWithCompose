package com.ipsmeet.retrofitwithcompose.quote.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ipsmeet.retrofitwithcompose.R
import com.ipsmeet.retrofitwithcompose.ui.theme.RetrofitWithComposeTheme

@Composable
fun QuoteView(quote: String, author: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = MaterialTheme.shapes.medium
            )   // row - modifier - background
            .padding(9.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.round_format_quote_24),
            contentDescription = "Quote Icon",
            modifier = Modifier
                .size(45.dp)
                .weight(1f)
                .rotate(180f)
        )   // image
        Column(
            modifier = Modifier
                .weight(4f)
        ) {
            Text(
                text = quote,
                fontSize = 24.sp,
                style = MaterialTheme.typography.labelMedium,
                lineHeight = 24.sp,
                letterSpacing = 0.15.sp
            )   // text - quote
            Text(
                text = author,
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 5.dp)
            )   // text - author
        }   // column
    }   // row
}

@Preview(showBackground = true)
@Composable
fun PreviewQuoteView() {
    RetrofitWithComposeTheme {
        QuoteView("Dummy Quote", "Meet Patadia")
    }
}