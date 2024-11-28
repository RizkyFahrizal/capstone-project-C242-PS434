package com.example.homepage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homepage.adapter.CategoriesAdapter
import com.example.homepage.data.Category
import com.example.homepage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tambahkan inisialisasi RecyclerView
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        // Contoh data kategori
        val categories = listOf(
            Category("Pizza", R.drawable.ic_logo),  // Ganti `R.drawable.ic_pizza` dengan resource yang sesuai
            Category("Burger", R.drawable.ic_logo),
            Category("Drinks", R.drawable.ic_logo),
            Category("Dessert", R.drawable.ic_logo)
        )

        // Inisialisasi adapter
        val adapter = CategoriesAdapter(categories) { category ->
            // Handle klik item
            showToast("Clicked on: ${category.name}")
        }

        // Set RecyclerView
        binding.rvCategories.layoutManager = LinearLayoutManager(this)
        binding.rvCategories.adapter = adapter
    }

    private fun showToast(message: String) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }
}
