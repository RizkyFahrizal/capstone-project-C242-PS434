package com.example.stateruppage.data

data class RegisterResponse(
    val status: String,
    val message: String,
    val dataUser: User
)

data class User(
    val user_id: String,
    val username: String,
    val email: String,
    val password: String
)

data class RegisterRequest(
    val username: String,
    val email: String,
    val password: String
)