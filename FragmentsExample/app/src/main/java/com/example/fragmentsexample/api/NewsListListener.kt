package com.example.fragmentsexample.api

import com.example.fragmentsexample.model.NewsListModel

interface NewsListListener {
    fun onNewsListReceived(newsList: NewsListModel?)
}