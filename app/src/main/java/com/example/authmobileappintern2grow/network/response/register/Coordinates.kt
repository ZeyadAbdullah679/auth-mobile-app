package com.example.authmobileappintern2grow.network.response.register


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    @SerialName("lat")
    val lat: Double,
    @SerialName("lng")
    val lng: Double
)