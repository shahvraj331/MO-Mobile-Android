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

class HomeSpecialFragmentAdapter(private var itemList: ArrayList<HomeData>) : RecyclerView.Adapter<HomeSpecialFragmentAdapter.ViewHolder>() {
    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_special_offer,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.offer?.text  = item.offer
        item.image?.let { holder.image?.setImageResource(it) }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var offer: TextView? = null
        var image: ImageView? = null

        init {
            offer =  itemView.findViewById(R.id.tvSpecialOffer)
            image =  itemView.findViewById(R.id.ivSpecialOffer)
        }
    }
}