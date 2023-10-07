package com.example.authmobileappintern2grow.network.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterUserRequest(
    @SerialName(value = "username")
    val username: String,
    @SerialName(value = "email")
    val email: String,
    @SerialName(value = "password")
    val password: String
)