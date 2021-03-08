package com.example.fragmentsexample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.fragmentsexample.api.NewsListListener
import com.example.fragmentsexample.api.NewsListProvider
import com.example.fragmentsexample.model.NewsListModel

class NewsListFragment : Fragment(R.layout.news_list_fragment_layout) {
    private lateinit var navigationController: NavigationController
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var newsListView: RecyclerView
    private lateinit var loadingView: View
    private lateinit var newsListProvider: NewsListProvider

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val baseActivity = requireActivity() as MainActivity
        navigationController = baseActivity.navigationController
        newsListProvider = baseActivity.newsListProvider
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout)
        newsListView = view.findViewById(R.id.news_list)
        loadingView = view.findViewById(R.id.loading)
        swipeRefreshLayout.setOnRefreshListener {
            refreshNewsList()
        }
        refreshNewsList()
        newsListView.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
    }

    private fun refreshNewsList() {
        newsListProvider.provideNewsList(object : NewsListListener {
            override fun onNewsListReceived(newsList: NewsListModel?) {
                swipeRefreshLayout.isRefreshing = false
                newsList?.let { list ->
                    loadingView.visibility = View.GONE
                    newsListView.visibility = View.VISIBLE
                    newsListView.adapter = navigationController?.let {
                        NewsListAdapter(list, it)
                    }
                    newsListView.adapter?.notifyDataSetChanged()
                }
            }
        })
    }
}