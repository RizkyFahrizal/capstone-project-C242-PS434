package com.example.stateruppage.food.foodPedas

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.stateruppage.R

class DetailFoodPedasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_food)

        val name = intent.getStringExtra("PRODUCT_NAME")
        val desc = intent.getStringExtra("PRODUCT_DESC")
        val image = intent.getStringExtra("PRODUCT_PIC")
        val category = intent.getStringExtra("PRODUCT_CATEGORY")

        val tvName: TextView = findViewById(R.id.tv_brand_name)
        val tvDesc: TextView = findViewById(R.id.tv_brand_description)
        val ivBanner: ImageView = findViewById(R.id.iv_banner)

        tvName.text = name ?: "N/A"
        tvDesc.text = desc ?: "N/A"

        Glide.with(this)
            .load(image)
            .into(ivBanner)
    }
}
