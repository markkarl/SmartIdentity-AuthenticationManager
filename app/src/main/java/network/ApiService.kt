package com.example.smart_identity_authentication_manager.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class User(val id: Int, val email: String, val password: String)
data class AuthResponse(val token: String)
data class RegisterRequest(val email: String, val password: String)
data class LoginRequest(val email: String, val password: String)

interface ApiService {
    @POST("register")
    fun register(@Body registerRequest: RegisterRequest): Call<AuthResponse>

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Call<AuthResponse>
}
