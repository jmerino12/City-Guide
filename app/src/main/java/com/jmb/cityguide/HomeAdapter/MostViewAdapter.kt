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
class MostViewAdapter() : RecyclerView.Adapter<MostViewAdapter.MostViewViewHolder>() {
    var items: List<FeaturedHelperClass> = ArrayList()
    public constructor(items: List<FeaturedHelperClass>) : this() {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.the_mosted_card_desing, parent, false)
        return MostViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: MostViewViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.image)
        holder.name.text = item.title
        holder.rating.rating = item.rate
        holder.description.text = item.description
    }

    override fun getItemCount(): Int = items.size

    inner class MostViewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById(R.id.ms_Image) as ImageView
        val name = view.findViewById(R.id.ms_name) as TextView
        val description = view.findViewById(R.id.ms_description) as TextView
        val rating = view.findViewById(R.id.ms_rating) as RatingBar
    }


}