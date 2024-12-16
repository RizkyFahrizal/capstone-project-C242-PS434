package com.example.stateruppage.home

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stateruppage.R
import com.example.stateruppage.adapter.CategoriesAdapter
import com.example.stateruppage.adapter.TrendingAdapter
import com.example.stateruppage.data.Category
import com.example.stateruppage.data.Trending
import com.example.stateruppage.databinding.ActivityHomeBinding
import com.example.stateruppage.food.foodAsam.FoodAsamActivity
import com.example.stateruppage.food.foodAsin.FoodAsinActivity
import com.example.stateruppage.food.foodManis.FoodManisActivity
import com.example.stateruppage.food.foodPahit.FoodPahitActivity
import com.example.stateruppage.food.foodPedas.FoodPedasActivity
import com.example.stateruppage.food.foodgurih.FoodGurihActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Inisialisasi RecyclerView untuk Categories
        setupCategoriesRecyclerView()

        // Inisialisasi RecyclerView untuk News & Trending
        setupTrendingRecyclerView()
    }

    private fun setupCategoriesRecyclerView() {
        // Data kategori
        val categories = listOf(
            Category("Asin", R.drawable.logo_asin),
            Category("Gurih", R.drawable.logo_gurih),
            Category("Manis", R.drawable.logo_manis),
            Category("Asam", R.drawable.logo_pahit),
            Category("Pedas", R.drawable.logo_pedas2),
            Category("Pahit", R.drawable.rb_34622)
        )

        // Inisialisasi adapter
        val adapter = CategoriesAdapter(categories) { category ->
            when (category.name) {
                "Asin" -> {
                    // Pindah ke FoodAsin Activity
                    val intent = Intent(this, FoodAsinActivity::class.java)
                    startActivity(intent)
                }
                "Gurih" -> {
                    // Pindah ke FoodGurih Activity
                    val intent = Intent(this, FoodGurihActivity::class.java)
                    startActivity(intent)
                }
                "Manis" -> {
                    // Pindah ke FoodGurih Activity
                    val intent = Intent(this, FoodManisActivity::class.java)
                    startActivity(intent)
                }
                "Asam" -> {
                    // Pindah ke FoodGurih Activity
                    val intent = Intent(this, FoodAsamActivity ::class.java)
                    startActivity(intent)
                }
                "Pedas" -> {
                    // Pindah ke FoodGurih Activity
                    val intent = Intent(this, FoodPedasActivity ::class.java)
                    startActivity(intent)
                }
                "Pahit" -> {
                    // Pindah ke Foodlainnya Activity
                    val intent = Intent(this, FoodPahitActivity ::class.java)
                    startActivity(intent)
                }
                else -> {
                    showToast("Clicked on: ${category.name}")
                }
            }
        }


        // Atur RecyclerView dengan GridLayoutManager (3 kolom)
        binding.rvCategories.layoutManager = GridLayoutManager(this, 3)
        binding.rvCategories.addItemDecoration(GridSpacingItemDecoration(3, 16)) // Tambahkan dekorasi
        binding.rvCategories.adapter = adapter
    }

    private fun setupTrendingRecyclerView() {
        // Data trending
        val trendingItems = listOf(
            Trending("Rawon Pak Pangat", R.drawable.rawon, "2.300 disukai"),
            Trending("Seafood Bang Jaja", R.drawable.soto_ayam, "1.500 disukai"),
            Trending("Bebek Sinjay", R.drawable.complete_1, "3.000 disukai")
        )

        // Inisialisasi adapter
        val trendingAdapter = TrendingAdapter(trendingItems) { trending ->
            // Handle klik item
            showToast("Clicked on: ${trending.title}")
        }

        // Atur RecyclerView dengan LinearLayoutManager horizontal
        binding.rvTrending.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTrending.adapter = trendingAdapter
    }

    private fun showToast(message: String) {
        android.widget.Toast.makeText(this, message, android.widget.Toast.LENGTH_SHORT).show()
    }

    // GridSpacingItemDecoration untuk spasi antar item di grid
    class GridSpacingItemDecoration(private val spanCount: Int, private val spacing: Int) :
        RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            val position = parent.getChildAdapterPosition(view)
            val column = position % spanCount
            outRect.left = spacing - column * spacing / spanCount
            outRect.right = (column + 1) * spacing / spanCount
            if (position < spanCount) outRect.top = spacing
            outRect.bottom = spacing
        }
    }
}
