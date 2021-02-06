package com.example.fragmentsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val newsFragment = NewsFragment()
    private val newsListFragment = NewsListFragment()
    private lateinit var navigationController: NavigationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationController = NavigationControllerImpl(
            newsFragment,
            newsListFragment,
            supportFragmentManager,
            findViewById(R.id.news_list_holder),
            findViewById(R.id.news_holder),
            this::finish
        )
        newsListFragment.navigationController = navigationController
        newsFragment.navigationController = navigationController
        navigationController.open()
    }

    override fun onDestroy() {
        super.onDestroy()
        navigationController.close()
    }
}