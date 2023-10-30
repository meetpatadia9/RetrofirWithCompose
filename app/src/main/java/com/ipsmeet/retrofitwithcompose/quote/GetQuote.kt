package com.ipsmeet.retrofitwithcompose.quote

import com.ipsmeet.retrofitwithcompose.quote.dataclass.QuoteMainDataClass
import retrofit2.Call
import retrofit2.http.GET

interface GetQuote {

    @GET("/quotes")
    fun getQuotes(): Call<QuoteMainDataClass>

}