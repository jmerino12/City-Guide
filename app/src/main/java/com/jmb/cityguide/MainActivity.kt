package com.jmb.cityguide


import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jmb.cityguide.HomeAdapter.*


class MainActivity : AppCompatActivity() {
    lateinit var featuredRecycler: RecyclerView
    lateinit var categoiresRecycler: RecyclerView
    lateinit var mostViewRecycler: RecyclerView


    var mAdapter: FeaturedAdapter = FeaturedAdapter()
    var mAdapterCategories: CategoriesAdapter = CategoriesAdapter()
    var mAdapterMostView: MostViewAdapter = MostViewAdapter()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        featuredRecycler = findViewById(R.id.rv_features)
        categoiresRecycler = findViewById(R.id.rv_categories)
        mostViewRecycler = findViewById(R.id.rv_mosviewed)
        featuredRecycler()
        categoriesRecycler()
        MostViewRecycler()
    }

    private fun categoriesRecycler() {
        categoiresRecycler.setHasFixedSize(true)
        categoiresRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mAdapterCategories = CategoriesAdapter(getCategories())
        categoiresRecycler.adapter = mAdapterCategories

       // val drawable = GradientDrawable(
         //       GradientDrawable.Orientation.LEFT_RIGHT, intArrayOf( Color.BLUE,Color.RED))
        //featuredRecycler.background = drawable
    }

    private fun featuredRecycler() {
        featuredRecycler.setHasFixedSize(true)
        featuredRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mAdapter = FeaturedAdapter(getFeatured())
        featuredRecycler.adapter = mAdapter



    }

    private fun MostViewRecycler() {
        mostViewRecycler.setHasFixedSize(true)
        mostViewRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mAdapterMostView = MostViewAdapter(getMostView())
        mostViewRecycler.adapter = mAdapterMostView
    }

    fun getFeatured(): MutableList<FeaturedHelperClass> {
        var list: MutableList<FeaturedHelperClass> = ArrayList()
        list.add(FeaturedHelperClass(R.drawable.macdonals, "Mc Donals", "skjdjksad jksdsakda dhajsdhjsda", 3.5F))
        list.add(FeaturedHelperClass(R.drawable.mimi, "Mimi", "Delicioso postres", 4.5F))
        list.add(FeaturedHelperClass(R.drawable.ic_add, "Boreal", "Todo sabroso", 4.0F))
        list.add(FeaturedHelperClass(R.drawable.snack, "Snack fit meet", "Postres saludables", 4.8F))
        return list
    }

    fun getMostView(): MutableList<FeaturedHelperClass> {
        var list: MutableList<FeaturedHelperClass> = ArrayList()
        list.add(FeaturedHelperClass(R.drawable.macdonals, "Mc Donals", "skjdjksad jksdsakda dhajsdhjsda", 3.5F))
        list.add(FeaturedHelperClass(R.drawable.mimi, "Mimi", "Delicioso postres", 4.5F))
        list.add(FeaturedHelperClass(R.drawable.ic_add, "Boreal", "Todo sabroso", 4.0F))
        list.add(FeaturedHelperClass(R.drawable.snack, "Snack fit meet", "Postres saludables", 4.8F))
        return list
    }

    fun getCategories(): MutableList<CategoriesHelperClass>{
        var list: MutableList<CategoriesHelperClass> = ArrayList()
        list.add(CategoriesHelperClass(R.drawable.education, "Education"))
        list.add(CategoriesHelperClass(R.drawable.hospital, "Hospital"))
        list.add(CategoriesHelperClass(R.drawable.peoplerestaurant, "Restaurant"))
        return list
    }
}