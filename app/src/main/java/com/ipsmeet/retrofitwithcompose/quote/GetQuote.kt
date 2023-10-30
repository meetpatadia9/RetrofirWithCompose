package com.ipsmeet.retrofitwithcompose.quote

import com.ipsmeet.retrofitwithcompose.quote.dataclass.QuoteMainDataClass
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetQuote {

    @GET("/quotes")
    fun getQuotes(
        @Query("limit") limit: Int
    ): Call<QuoteMainDataClass>

}