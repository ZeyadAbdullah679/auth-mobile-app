package com.example.authmobileappintern2grow.network.response.register


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hair(
    @SerialName("color")
    val color: String,
    @SerialName("type")
    val type: String
)