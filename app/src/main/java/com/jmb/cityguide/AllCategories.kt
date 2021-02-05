package com.jmb.cityguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class AllCategories : AppCompatActivity() {
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_categories)

        imageView = findViewById(R.id.btn_back)
    }

    override fun onBackPressed() {
        imageView.setOnClickListener { super.onBackPressed() }

    }
}