package com.example.stateruppage.food.foodPahit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stateruppage.ApiObject
import com.example.stateruppage.R
import com.example.stateruppage.data.Product

class FoodPahitActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodpahitdapter: FoodPahitListAdapter
    private var productList: MutableList<Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_pahit)

        recyclerView = findViewById(R.id.rv_brands)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Memanggil API untuk mendapatkan data pedas
        fetchPahitData()
    }

    private fun fetchPahitData() {
        ApiObject.getPahitData(
            onResponse = { PahitResponse ->
                PahitResponse?.let {
                    productList.addAll(it.data)
                    foodpahitdapter = FoodPahitListAdapter(this@FoodPahitActivity, productList)
                    recyclerView.adapter = foodpahitdapter
                }
            },
            onFailure = { throwable ->
                Toast.makeText(this, "Failed to load data: ${throwable.message}", Toast.LENGTH_SHORT).show()
            }
        )
    }
}


