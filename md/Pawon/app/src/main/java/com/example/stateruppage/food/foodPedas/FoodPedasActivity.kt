package com.example.stateruppage.food.foodPedas

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stateruppage.ApiObject
import com.example.stateruppage.R
import com.example.stateruppage.data.Product

class FoodPedasActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodpedasdapter: FoodPedasListAdapter
    private var productList: MutableList<Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_pedas)

        recyclerView = findViewById(R.id.rv_brands)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Memanggil API untuk mendapatkan data pedas
        fetchPedasData()
    }

    private fun fetchPedasData() {
        ApiObject.getPedasData(
            onResponse = { PedasResponse ->
                PedasResponse?.let {
                    productList.addAll(it.data)
                    foodpedasdapter = FoodPedasListAdapter(this@FoodPedasActivity, productList)
                    recyclerView.adapter = foodpedasdapter
                }
            },
            onFailure = { throwable ->
                Toast.makeText(this, "Failed to load data: ${throwable.message}", Toast.LENGTH_SHORT).show()
            }
        )
    }
}


