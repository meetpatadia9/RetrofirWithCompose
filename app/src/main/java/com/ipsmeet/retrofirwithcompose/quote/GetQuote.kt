package com.ipsmeet.retrofirwithcompose.quote

import com.ipsmeet.retrofirwithcompose.quote.dataclass.QuoteMainDataClass
import retrofit2.Call
import retrofit2.http.GET

interface GetQuote {

    @GET("/quotes")
    fun getQuotes(): Call<QuoteMainDataClass>

}