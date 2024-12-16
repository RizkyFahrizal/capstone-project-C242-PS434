package com.example.stateruppage

import com.example.stateruppage.data.AsamResponse
import com.example.stateruppage.data.AsinResponse
import com.example.stateruppage.data.GurihResponse
import com.example.stateruppage.data.LoginRequest
import com.example.stateruppage.data.LoginResponse
import com.example.stateruppage.data.ManisResponse
import com.example.stateruppage.data.PahitResponse
import com.example.stateruppage.data.PedasResponse
import com.example.stateruppage.data.RegisterRequest
import com.example.stateruppage.data.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiObject {

    private const val BASE_URL = "https://backend-pawon-v-1-0-2-mwuvzqa5iq-et.a.run.app/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // API Service untuk Login
    private val loginService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    // API Service untuk Register
    private val registerService: RegisterApiService by lazy {
        retrofit.create(RegisterApiService::class.java)
    }

    // Fungsi untuk login
    fun loginUser(loginRequest: LoginRequest, onResponse: (LoginResponse?) -> Unit, onFailure: (Throwable) -> Unit) {
        loginService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    onResponse(response.body())
                } else {
                    onFailure(Throwable("Login failed"))
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                onFailure(t)
            }
        })
    }

    // Fungsi untuk register
    fun registerUser(registerRequest: RegisterRequest, onResponse: (RegisterResponse?) -> Unit, onFailure: (Throwable) -> Unit) {
        registerService.registerUser(registerRequest).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.isSuccessful) {
                    onResponse(response.body())
                } else {
                    // Menambahkan log untuk memeriksa respons error
                    println("Registration failed: ${response.message()}")
                    onFailure(Throwable("Registration failed"))
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                println("Registration failed: ${t.message}")
                onFailure(t)
            }
        })
    }

    // Fungsi untuk mendapatkan data produk asin
    fun getAsinData(onResponse: (AsinResponse?) -> Unit, onFailure: (Throwable) -> Unit) {
        retrofit.create(ApiService::class.java)
            .getAsinData()
            .enqueue(object : Callback<AsinResponse> {
                override fun onResponse(call: Call<AsinResponse>, response: Response<AsinResponse>) {
                    if (response.isSuccessful) {
                        onResponse(response.body())
                    } else {
                        onFailure(Throwable("Failed to load asin data"))
                    }
                }

                override fun onFailure(call: Call<AsinResponse>, t: Throwable) {
                    onFailure(t)
                }
            })
    }

    // Fungsi untuk mendapatkan data produk gurih
    fun getGurihData(onResponse: (GurihResponse?) -> Unit, onFailure: (Throwable) -> Unit) {
        retrofit.create(ApiService::class.java)
            .getGurihData()
            .enqueue(object : Callback<GurihResponse> {
                override fun onResponse(call: Call<GurihResponse>, response: Response<GurihResponse>) {
                    if (response.isSuccessful) {
                        onResponse(response.body())
                    } else {
                        onFailure(Throwable("Failed to load gurih data"))
                    }
                }

                override fun onFailure(call: Call<GurihResponse>, t: Throwable) {
                    onFailure(t)
                }
            })
    }

    // Fungsi untuk mendapatkan data produk gurih
    fun getManisData(onResponse: (ManisResponse?) -> Unit, onFailure: (Throwable) -> Unit) {
        retrofit.create(ApiService::class.java)
            .getManisData()
            .enqueue(object : Callback<ManisResponse> {
                override fun onResponse(call: Call<ManisResponse>, response: Response<ManisResponse>) {
                    if (response.isSuccessful) {
                        onResponse(response.body())
                    } else {
                        onFailure(Throwable("Failed to load gurih data"))
                    }
                }

                override fun onFailure(call: Call<ManisResponse>, t: Throwable) {
                    onFailure(t)
                }
            })
    }

    fun getAsamData(onResponse: (AsamResponse?) -> Unit, onFailure: (Throwable) -> Unit) {
        retrofit.create(ApiService::class.java)
            .getAsamData()
            .enqueue(object : Callback<AsamResponse> {
                override fun onResponse(call: Call<AsamResponse>, response: Response<AsamResponse>) {
                    if (response.isSuccessful) {
                        onResponse(response.body())
                    } else {
                        onFailure(Throwable("Failed to load asam data"))
                    }
                }

                override fun onFailure(call: Call<AsamResponse>, t: Throwable) {
                    onFailure(t)
                }
            })
    }

    // Fungsi untuk mendapatkan data produk gurih
    fun getPedasData(onResponse: (PedasResponse?) -> Unit, onFailure: (Throwable) -> Unit) {
        retrofit.create(ApiService::class.java)
            .getPedasData()
            .enqueue(object : Callback<PedasResponse> {
                override fun onResponse(call: Call<PedasResponse>, response: Response<PedasResponse>) {
                    if (response.isSuccessful) {
                        onResponse(response.body())
                    } else {
                        onFailure(Throwable("Failed to load gurih data"))
                    }
                }

                override fun onFailure(call: Call<PedasResponse>, t: Throwable) {
                    onFailure(t)
                }
            })
    }

    // Fungsi untuk mendapatkan data produk gurih
    fun getPahitData(onResponse: (PahitResponse?) -> Unit, onFailure: (Throwable) -> Unit) {
        retrofit.create(ApiService::class.java)
            .getPahitData()
            .enqueue(object : Callback<PahitResponse> {
                override fun onResponse(call: Call<PahitResponse>, response: Response<PahitResponse>) {
                    if (response.isSuccessful) {
                        onResponse(response.body())
                    } else {
                        onFailure(Throwable("Failed to load gurih data"))
                    }
                }

                override fun onFailure(call: Call<PahitResponse>, t: Throwable) {
                    onFailure(t)
                }
            })
    }

}
