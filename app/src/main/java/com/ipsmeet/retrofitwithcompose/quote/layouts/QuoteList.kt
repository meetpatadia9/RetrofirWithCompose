package com.ipsmeet.retrofitwithcompose.quote.layouts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ipsmeet.retrofitwithcompose.quote.dataclass.QuoteDataClass
import com.ipsmeet.retrofitwithcompose.quote.dataclass.QuoteMainDataClass
import com.ipsmeet.retrofitwithcompose.ui.theme.RetrofitWithComposeTheme

@Composable
fun QuoteList(quoteMainDataClass: QuoteMainDataClass) {
    val quoteList = quoteMainDataClass.quotes

    LazyColumn(Modifier.fillMaxSize().padding(3.dp)) {
        items(quoteList) {
            QuoteView(quote = it.quote, author = it.author)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewQuoteList() {
    val quoteList = listOf(
        QuoteDataClass(1, "Quote #1", "Author #1"),
        QuoteDataClass(2, "Quote #2", "Author #2"),
        QuoteDataClass(3, "Quote #3", "Author #3")
    )

    RetrofitWithComposeTheme {
        QuoteList(
            QuoteMainDataClass(
                limit = 30,
                quotes = quoteList,
                skip = 0,
                total = 100
            )
        )
    }
}