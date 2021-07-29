package com.dc.kotlinrepository.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dc.kotlinrepository.R
import com.dc.kotlinrepository.entity.HomeDataResponse

class HomeInfoAdapter private constructor() : RecyclerView.Adapter<HomeInfoAdapter.HomeInfoViewHolder>() {

    private lateinit var mNews: List<HomeDataResponse.NewsListBean>

    private lateinit var context: Context

    constructor(context: Context, news: List<HomeDataResponse.NewsListBean>) : this() {
        this.context = context
        mNews = news
    }

    inner class HomeInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsText : TextView = itemView.findViewById(R.id.news_text)
        val newDate: TextView = itemView.findViewById(R.id.news_date);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeInfoViewHolder {
        return HomeInfoViewHolder(LayoutInflater.from(context).inflate(R.layout.home_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: HomeInfoViewHolder, position: Int) {
        val news = mNews[position]
        holder.newsText.text = news.title
        holder.newDate.text = news.create_time
    }

    override fun getItemCount(): Int = mNews.size

}