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
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @GET("asin")  // Gantilah dengan endpoint yang sesuai di backend
    fun getAsinData(): Call<AsinResponse>

    @GET("gurih")  // Gantilah dengan endpoint yang sesuai di backend
    fun getGurihData(): Call<GurihResponse>

    @GET("manis")  // Gantilah dengan endpoint yang sesuai di backend
    fun getManisData(): Call<ManisResponse>

    @GET("asam")  // Gantilah dengan endpoint yang sesuai di backend
    fun getAsamData(): Call<AsamResponse>

    @GET("pedas")  // Gantilah dengan endpoint yang sesuai di backend
    fun getPedasData(): Call<PedasResponse>

    @GET("pahit")  // Gantilah dengan endpoint yang sesuai di backend
    fun getPahitData(): Call<PahitResponse>

}

interface RegisterApiService {
    @POST("user")
    fun registerUser(@Body registerRequest: RegisterRequest): Call<RegisterResponse>
}
