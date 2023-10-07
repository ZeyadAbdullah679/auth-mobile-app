package com.example.authmobileappintern2grow.network.response.register


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Address(
    @SerialName("address")
    val address: String,
    @SerialName("city")
    val city: String,
    @SerialName("coordinates")
    val coordinates: Coordinates,
    @SerialName("postalCode")
    val postalCode: String,
    @SerialName("state")
    val state: String
)