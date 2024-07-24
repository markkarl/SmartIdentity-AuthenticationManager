package com.example.smart_identity_authentication_manager.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

data class User(val id: Int, val name: String, val email: String)

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("users/{id}")
    fun getUserById(@Path("id") id: Int): Call<User>
}
