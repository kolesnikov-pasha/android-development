package com.example.fragmentsexample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class NewsListFragment : Fragment(R.layout.news_list_fragment_layout) {
    var navigationController: NavigationController? = null
    lateinit var news: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        news = view.findViewById(R.id.news_1)
        news.setOnClickListener {
            navigationController?.onNewsClick()
        }
    }

}