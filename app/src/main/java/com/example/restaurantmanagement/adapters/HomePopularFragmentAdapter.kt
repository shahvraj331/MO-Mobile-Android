package com.example.restaurantmanagement.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantmanagement.HomeData
import com.example.restaurantmanagement.R


class HomePopularFragmentAdapter(private var itemList: ArrayList<HomeData>) : RecyclerView.Adapter<HomePopularFragmentAdapter.ViewHolder>() {
    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_popular_items,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = itemList[position]
        holder.title?.text  = item.title
        item.image?.let { holder.image?.setImageResource(it) }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView? = null
        var image: ImageView? = null

        init {
            title =  itemView.findViewById(R.id.tvPopularItemTitle)
            image =  itemView.findViewById(R.id.ivPopularItem)
        }
    }
}