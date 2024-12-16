package com.example.stateruppage.food.foodAsin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stateruppage.ApiObject
import com.example.stateruppage.R
import com.example.stateruppage.data.Product

class FoodAsinActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodasindapter: FoodAsinListAdapter
    private var productList: MutableList<Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_asin)

        recyclerView = findViewById(R.id.rv_brands)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Memanggil API untuk mendapatkan data asam
        fetchAsinData()
    }

    private fun fetchAsinData() {
        ApiObject.getAsinData(
            onResponse = { asinResponse ->
                asinResponse?.let {
                    productList.addAll(it.data)
                    foodasindapter = FoodAsinListAdapter(this@FoodAsinActivity, productList)
                    recyclerView.adapter = foodasindapter
                }
            },
            onFailure = { throwable ->
                Toast.makeText(this, "Failed to load data: ${throwable.message}", Toast.LENGTH_SHORT).show()
            }
        )
    }
}


