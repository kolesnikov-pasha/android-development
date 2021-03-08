package com.example.fragmentsexample

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.fragment.app.Fragment

class NewsFragment : Fragment(R.layout.news_fragment_layout) {

    private lateinit var webView: WebView
    private lateinit var navigationController: NavigationController
    private var url: String? = null

    fun setNewsUrl(url: String) {
        this.url = url
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val baseActivity = requireActivity() as MainActivity
        navigationController = baseActivity.navigationController
        webView = view.findViewById(R.id.news_web_view)
    }

    override fun onResume() {
        super.onResume()
        url?.let { webView.loadUrl(it) }
    }
}