package com.ipsmeet.retrofitwithcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ipsmeet.retrofitwithcompose.BaseURLs.DUMMY_JSON_BASE_URL
import com.ipsmeet.retrofitwithcompose.quote.GetQuote
import com.ipsmeet.retrofitwithcompose.quote.dataclass.QuoteMainDataClass
import com.ipsmeet.retrofitwithcompose.quote.layouts.QuoteList
import com.ipsmeet.retrofitwithcompose.ui.theme.RetrofirWithComposeTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuoteListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(DUMMY_JSON_BASE_URL)
            .build()
            .create(GetQuote::class.java)

        retrofitBuilder.getQuotes(100)
            .enqueue(object : Callback<QuoteMainDataClass?> {
                override fun onResponse(call: Call<QuoteMainDataClass?>, response: Response<QuoteMainDataClass?>) {
                    Log.d("onResponse: ", response.body()!!.quotes.size.toString())
                    setContent {
                        RetrofirWithComposeTheme {
                            QuoteList(quoteMainDataClass = response.body()!!)
                        }
                    }
                }

                override fun onFailure(call: Call<QuoteMainDataClass?>, t: Throwable) {
                    Log.e("onFailure: ", t.message.toString())
                }
            })
    }
}