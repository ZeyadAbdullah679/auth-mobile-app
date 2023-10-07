package com.example.authmobileappintern2grow.network.response.register


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Bank(
    @SerialName("cardExpire")
    val cardExpire: String,
    @SerialName("cardNumber")
    val cardNumber: String,
    @SerialName("cardType")
    val cardType: String,
    @SerialName("currency")
    val currency: String,
    @SerialName("iban")
    val iban: String
)