package com.example.fragmentsexample

import android.app.Activity

interface NavigationController {
    fun open()
    fun onNewsClick(url: String)
    fun onNewsClosed()
    fun close()
    fun onSettingsClick(activity: Activity)
}