package com.example.fragmentsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import com.example.fragmentsexample.api.NewsListProvider
import com.example.fragmentsexample.api.NewsListProviderImpl

class MainActivity : AppCompatActivity() {

    private val newsFragment = NewsFragment()
    private val newsListFragment = NewsListFragment()
    private lateinit var toolbar: Toolbar
    lateinit var navigationController: NavigationController
    lateinit var newsListProvider: NewsListProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        navigationController = NavigationControllerImpl(
            newsFragment,
            newsListFragment,
            supportFragmentManager,
            findViewById(R.id.news_list_holder),
            findViewById(R.id.news_holder)
        ) {}
        newsListProvider = NewsListProviderImpl()
    }

    override fun onResume() {
        super.onResume()
        navigationController.open()
    }

    override fun onPause() {
        super.onPause()
        navigationController.close()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}