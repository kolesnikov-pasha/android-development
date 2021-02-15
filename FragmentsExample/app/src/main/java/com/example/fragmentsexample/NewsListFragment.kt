package com.example.fragmentsexample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentsexample.model.NewsListParser

class NewsListFragment : Fragment(R.layout.news_list_fragment_layout) {
    var navigationController: NavigationController? = null
    lateinit var newsList: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsList = view.findViewById(R.id.news_list)
        val model = NewsListParser().parse(resources.assets.open("news.json"))
        newsList.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
        newsList.adapter = NewsListAdapter(model)
    }

}