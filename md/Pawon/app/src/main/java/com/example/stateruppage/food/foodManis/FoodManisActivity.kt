package com.example.stateruppage.food.foodManis

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stateruppage.ApiObject
import com.example.stateruppage.R
import com.example.stateruppage.data.Product

class FoodManisActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodmanisdapter: FoodManisListAdapter
    private var productList: MutableList<Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_manis)

        recyclerView = findViewById(R.id.rv_brands)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Memanggil API untuk mendapatkan data manis
        fetchManisData()
    }

    private fun fetchManisData() {
        ApiObject.getManisData(
            onResponse = { ManisResponse ->
                ManisResponse?.let {
                    productList.addAll(it.data)
                    foodmanisdapter = FoodManisListAdapter(this@FoodManisActivity, productList)
                    recyclerView.adapter = foodmanisdapter
                }
            },
            onFailure = { throwable ->
                Toast.makeText(this, "Failed to load data: ${throwable.message}", Toast.LENGTH_SHORT).show()
            }
        )
    }
}


