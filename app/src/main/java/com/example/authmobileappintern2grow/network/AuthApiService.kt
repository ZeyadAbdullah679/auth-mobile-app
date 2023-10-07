package com.example.authmobileappintern2grow.network

import com.example.authmobileappintern2grow.network.request.LoginUserRequest
import com.example.authmobileappintern2grow.network.request.RegisterUserRequest
import com.example.authmobileappintern2grow.network.response.login.LoginUserResponse
import com.example.authmobileappintern2grow.network.response.register.RegisterUserResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST

const val BASE_URL = "https://dummyjson.com/"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(
        Json.asConverterFactory("application/json".toMediaType())
    )
    .build()

interface ApiService {
    @POST("/users/add")
    suspend fun addUser(@Body userRequest: RegisterUserRequest): RegisterUserResponse

    @POST("/auth/login")
    suspend fun login(@Body loginRequest: LoginUserRequest): LoginUserResponse
}

object AuthApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}