package com.example.stateruppage.data


data class AsinResponse(
    val status: String,
    val data: List<Product>
)

data class GurihResponse(
    val status: String,
    val data: List<Product>
)

data class ManisResponse(
    val status: String,
    val data: List<Product>
)

data class AsamResponse(
    val status: String,
    val data: List<Product>
)

data class PedasResponse(
    val status: String,
    val data: List<Product>
)

data class PahitResponse(
    val status: String,
    val data: List<Product>
)

data class Product(
    val product_id: String,
    val history: History
)

data class History(
    val product_name: String,
    val product_pic: String,
    val product_category: String,
    val product_desc: String
)
