package com.example.fragmentsexample

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentsexample.model.NewsModel

class NewsViewHolder(
    parent: ViewGroup,
    private val navigationController: NavigationController
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.news_list_item_layout, parent, false)
) {

    private val section: TextView
    private val title: TextView
    private val abstract: TextView
    private var model: NewsModel? = null

    init {
        section = itemView.findViewById(R.id.section)
        title = itemView.findViewById(R.id.title)
        abstract = itemView.findViewById(R.id.abstract_text)
        itemView.setOnClickListener {
            model?.let { navigationController.onNewsClick(it.url) }
        }
    }

    fun bind(model: NewsModel) {
        this.model = model
        if (model.subsection.isEmpty()) {
            section.text = model.section
        } else {
            section.text = "${model.section} / ${model.subsection}"
        }
        title.text = model.title
        abstract.text = model.abstract
    }
}