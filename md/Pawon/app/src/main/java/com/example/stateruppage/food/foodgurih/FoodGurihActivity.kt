package com.example.stateruppage.food.foodgurih

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stateruppage.ApiObject
import com.example.stateruppage.R
import com.example.stateruppage.data.Product

class FoodGurihActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var foodGurihAdapter: FoodGurihListAdapter
    private var productList: MutableList<Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_gurih)

        recyclerView = findViewById(R.id.rv_brands)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Memanggil API untuk mendapatkan data gurih
        fetchGurihData()
    }

    private fun fetchGurihData() {
        ApiObject.getGurihData(
            onResponse = { gurihResponse ->
                gurihResponse?.let {
                    productList.addAll(it.data)
                    foodGurihAdapter = FoodGurihListAdapter(this@FoodGurihActivity, productList)
                    recyclerView.adapter = foodGurihAdapter
                }
            },
            onFailure = { throwable ->
                Toast.makeText(this, "Failed to load data: ${throwable.message}", Toast.LENGTH_SHORT).show()
            }
        )
    }
}



