package com.ipsmeet.retrofirwithcompose.quote.dataclass

data class QuoteMainDataClass(
    val limit: Int,
    val quotes: List<QuoteDataClass>,
    val skip: Int,
    val total: Int
)