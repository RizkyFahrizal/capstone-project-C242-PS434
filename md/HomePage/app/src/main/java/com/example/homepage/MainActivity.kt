package com.example.homepage

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
import com.example.homepage.adapter.CategoriesAdapter
import com.example.homepage.adapter.TrendingAdapter
import com.example.homepage.data.Category
import com.example.homepage.data.Trending
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

        // Inisialisasi RecyclerView untuk Categories
        setupCategoriesRecyclerView()

        // Inisialisasi RecyclerView untuk News & Trending
        setupTrendingRecyclerView()
    }

    private fun setupCategoriesRecyclerView() {
        // Data kategori
        val categories = listOf(
            Category("Fast Food", R.drawable.ic_logo),
            Category("Traditional", R.drawable.ic_logo),
            Category("Western", R.drawable.ic_logo),
            Category("Dessert", R.drawable.ic_logo),
            Category("Drinks", R.drawable.ic_logo),
            Category("Other", R.drawable.ic_logo)
        )

        // Inisialisasi adapter
        val adapter = CategoriesAdapter(categories) { category ->
            // Handle klik item
            showToast("Clicked on: ${category.name}")
        }

        // Atur RecyclerView dengan GridLayoutManager (3 kolom)
        binding.rvCategories.layoutManager = GridLayoutManager(this, 3)
        binding.rvCategories.addItemDecoration(GridSpacingItemDecoration(3, 16)) // Tambahkan dekorasi
        binding.rvCategories.adapter = adapter
    }

    private fun setupTrendingRecyclerView() {
        // Data trending
        val trendingItems = listOf(
            Trending("Rawon Pak Pangat", R.drawable.complete_1, "2.300 disukai"),
            Trending("Seafood Bang Jaja", R.drawable.complete_1, "1.500 disukai"),
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
