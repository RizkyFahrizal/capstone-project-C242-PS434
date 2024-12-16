package com.example.stateruppage.data

data class Category(
    val name: String,
    val imageResId: Int // Resource ID untuk gambar kategori
)

data class Trending(
    val title: String,
    val imageResId: Int,
    val votes: String
)