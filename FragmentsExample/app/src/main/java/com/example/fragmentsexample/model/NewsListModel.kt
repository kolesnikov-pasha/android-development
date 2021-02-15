package com.example.fragmentsexample.model

data class NewsListModel(
    val success: Boolean,
    val newsAmount: Int,
    val news: List<NewsModel>
) {
    class Builder(
        var success: Boolean = false,
        var newsAmount: Int = 0,
        var news: List<NewsModel> = listOf()
    ) {
        fun build() = NewsListModel(success, newsAmount, news)
    }
}