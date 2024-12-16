package com.example.stateruppage.data

data class LoginResponse(
    val status: String,
    val message: String,
    val data: UserData?
)

data class UserData(
    val user_id: String,
    val email: String,
    val fullname: String,
    val username: String
)

data class LoginRequest(
    val email: String,
    val password: String
)