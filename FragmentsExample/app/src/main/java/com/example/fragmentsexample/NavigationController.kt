package com.example.fragmentsexample

interface NavigationController {
    fun open()
    fun onNewsClick(url: String)
    fun onNewsClosed()
    fun close()
}