package com.example.fragmentsexample

import android.app.Activity
import android.content.Intent
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
        if (fragmentManager.findFragmentByTag(NEWS_LIST) != null) {
            return
        }
        fragmentManager
            .beginTransaction()
            .add(newsListFragmentHolder.id, newsListFragment, NEWS_LIST)
            .addToBackStack(NEWS_LIST)
            .commit()
    }

    override fun onNewsClick(url: String) {
        newsFragment.setNewsUrl(url)
        if (fragmentManager.findFragmentByTag(NEWS) != null) {
            return
        }
        newsFragmentHolder.visibility = View.VISIBLE
        fragmentManager
            .beginTransaction()
            .add(newsFragmentHolder.id, newsFragment, NEWS)
            .addToBackStack(NEWS)
            .commit()
    }

    override fun onNewsClosed() {
        newsFragmentHolder.visibility = View.GONE
        fragmentManager.popBackStack()
    }

    override fun onSettingsClick(activity: Activity) {
        activity.startActivity(
            Intent(activity, SettingActivity::class.java)
        )
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
        const val SETTINGS = "settings"
    }
}