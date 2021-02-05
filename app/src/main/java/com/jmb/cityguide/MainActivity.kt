package com.jmb.cityguide


import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.jmb.cityguide.HomeAdapter.*

const val END_SCALE = 0.7F

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var featuredRecycler: RecyclerView
    lateinit var categoiresRecycler: RecyclerView
    lateinit var mostViewRecycler: RecyclerView
    lateinit var imageView: ImageView
    lateinit var linearLayout: LinearLayout


    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView


    var mAdapter: FeaturedAdapter = FeaturedAdapter()
    var mAdapterCategories: CategoriesAdapter = CategoriesAdapter()
    var mAdapterMostView: MostViewAdapter = MostViewAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        featuredRecycler = findViewById(R.id.rv_features)
        categoiresRecycler = findViewById(R.id.rv_categories)
        mostViewRecycler = findViewById(R.id.rv_mosviewed)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        imageView = findViewById(R.id.menu_icon)
        linearLayout = findViewById(R.id.content)
        setupNavigationDrawer()
        featuredRecycler()
        categoriesRecycler()
        MostViewRecycler()
    }

    private fun setupNavigationDrawer() {
        navigationView.bringToFront()
        navigationView.setNavigationItemSelectedListener(this)
        navigationView.setCheckedItem(R.id.nav_home)
        imageView.setOnClickListener {
            if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }
        }
        animateNavigationDrawer()

    }

    private fun animateNavigationDrawer() {
        drawerLayout.setScrimColor(resources.getColor(R.color.primary))
        drawerLayout.addDrawerListener(object : DrawerLayout.SimpleDrawerListener() {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val diffScaledOffset: Float = slideOffset * (1 - END_SCALE)
                val offsetScaled: Float = 1 - diffScaledOffset

                linearLayout.scaleX = offsetScaled
                linearLayout.scaleY = offsetScaled

                val xOffSet: Float = drawerView.width * slideOffset
                val xOffSetDiff: Float = linearLayout.width * diffScaledOffset / 2
                val xTranslation: Float = xOffSet - xOffSetDiff
                linearLayout.translationX = xTranslation


            }
        })
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

    fun getCategories(): MutableList<CategoriesHelperClass> {
        var list: MutableList<CategoriesHelperClass> = ArrayList()
        list.add(CategoriesHelperClass(R.drawable.education, "Education"))
        list.add(CategoriesHelperClass(R.drawable.hospital, "Hospital"))
        list.add(CategoriesHelperClass(R.drawable.peoplerestaurant, "Restaurant"))
        return list
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.all_categories -> {
                val intent = Intent(this, AllCategories::class.java).apply {
                    putExtra(EXTRA_MESSAGE, "message")
                }
                startActivity(intent)
            }
        }
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()

        }
    }
}