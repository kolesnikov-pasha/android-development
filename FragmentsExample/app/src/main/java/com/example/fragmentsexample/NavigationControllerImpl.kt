package com.example.fragmentsexample

import android.view.View
import androidx.fragment.app.FragmentManager

class NavigationControllerImpl(
    private val newsFragment: NewsFragment,
    private val newsListFragment: NewsListFragment,
    private val fragmentManager: FragmentManager,
    private val newsListFragmentHolder: View,
    private val newsFragmentHolder: View,
    private val finishCallback: () -> Unit
) : NavigationController, FragmentManager.OnBackStackChangedListener {

    init {
        fragmentManager.addOnBackStackChangedListener(this)
    }

    override fun open() {
        fragmentManager.beginTransaction().add(newsListFragmentHolder.id, newsListFragment).addToBackStack(NEWS_LIST).commit()
    }

    override fun onNewsClick() {
        newsFragmentHolder.visibility = View.VISIBLE
        fragmentManager.beginTransaction().add(newsFragmentHolder.id, newsFragment, NEWS).addToBackStack(NEWS).commit()
    }

    override fun onNewsClosed() {
        newsFragmentHolder.visibility = View.GONE
        fragmentManager.popBackStack()
    }

    override fun close() {
        fragmentManager.removeOnBackStackChangedListener(this)
    }

    override fun onBackStackChanged() {
        if (fragmentManager.backStackEntryCount == 0) {
            finishCallback.invoke()
        }
        if (fragmentManager.backStackEntryCount == 1) {
            newsFragmentHolder.visibility = View.GONE
        }
    }

    private companion object {
        const val NEWS = "news"
        const val NEWS_LIST = "news_list"
    }
}