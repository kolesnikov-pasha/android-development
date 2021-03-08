package com.example.fragmentsexample

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentsexample.model.NewsListModel

class NewsListAdapter(
    private val model: NewsListModel,
    private val navigationController: NavigationController
) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(parent, navigationController)
    }

    override fun getItemCount(): Int {
        return model.results.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(model.results[position])
    }
}