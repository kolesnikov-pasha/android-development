package com.example.fragmentsexample.api

interface NewsListProvider {
    fun provideNewsList(listener: NewsListListener)
}