package com.example.fragmentsexample.api

import android.util.Log
import com.example.fragmentsexample.model.NewsListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsListProviderImpl : NewsListProvider {
    private val api = Retrofit.Builder()
        .baseUrl("https://api.nytimes.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)

    override fun provideNewsList(listener: NewsListListener) {
        api.getNews("all", "all", "ZcWzm2XNqZg4NiR95W4ppQ6n9SWrBMAn").enqueue(
            object : Callback<NewsListModel> {
                override fun onFailure(call: Call<NewsListModel>, t: Throwable) {
                    Log.e("KEK", "errrrrrrrrorrrr, error = ${t.message}")
                    t.printStackTrace()
                }

                override fun onResponse(call: Call<NewsListModel>, response: Response<NewsListModel>) {
                    listener.onNewsListReceived(response.body())
                }
            }
        )
    }
}