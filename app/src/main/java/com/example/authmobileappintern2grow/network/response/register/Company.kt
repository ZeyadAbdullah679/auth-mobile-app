package com.example.authmobileappintern2grow.network.response.register


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Company(
    @SerialName("address")
    val address: Address,
    @SerialName("department")
    val department: String,
    @SerialName("name")
    val name: String,
    @SerialName("title")
    val title: String
)