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
class CategoriesAdapter() : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {
    var items: List<CategoriesHelperClass> = ArrayList()
    public constructor(items: List<CategoriesHelperClass>) : this() {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_card_desing, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val item = items[position]
        holder.image.setImageResource(item.image)
        holder.name.text = item.title
    }

    override fun getItemCount(): Int = items.size

    inner class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById(R.id.image) as ImageView
        val name = view.findViewById(R.id.name) as TextView
    }


}