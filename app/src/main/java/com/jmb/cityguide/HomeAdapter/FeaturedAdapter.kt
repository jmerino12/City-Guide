package com.jmb.cityguide.HomeAdapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jmb.cityguide.R

/**
 * Created by jmerino on 2/2/21
 */
class FeaturedAdapter() : RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder>() {
    var items: List<FeaturedHelperClass> = ArrayList()
    public constructor(items: List<FeaturedHelperClass>) : this() {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.featured_card_desing, parent, false)
        return FeaturedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeaturedViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.image)
        holder.name.text = item.title
        holder.description.text = item.description
        holder.rating.rating = item.rate
    }

    override fun getItemCount(): Int = items.size

    inner class FeaturedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById(R.id.featured_image) as ImageView
        val name = view.findViewById(R.id.featured_title) as TextView
        val description = view.findViewById(R.id.featured_desc) as TextView
        val rating = view.findViewById(R.id.featured_rating) as RatingBar
    }


}