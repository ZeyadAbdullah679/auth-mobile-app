package com.example.authmobileappintern2grow.network.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterUserRequest(
    @SerialName("id")
    val id: Int,
    @SerialName("firstName")
    val firstName: String,
    @SerialName("lastName")
    val lastName: String,
    @SerialName("maidenName")
    val maidenName: String,
    @SerialName("age")
    val age: Int,
    @SerialName("gender")
    val gender: String,
    @SerialName("email")
    val email: String,
    @SerialName("phone")
    val phone: String,
    @SerialName("username")
    val username: String,
    @SerialName("password")
    val password: String,
    @SerialName("birthDate")
    val birthDate: String,
    @SerialName("image")
    val image: String,
    @SerialName("bloodGroup")
    val bloodGroup: String,
    @SerialName("height")
    val height: Double,
    @SerialName("weight")
    val weight: Double,
    @SerialName("eyeColor")
    val eyeColor: String,
    @SerialName("hair")
    val hair: Hair,
    @SerialName("domain")
    val domain: String,
    @SerialName("ip")
    val ip: String,
    @SerialName("address")
    val address: Address,
    @SerialName("macAddress")
    val macAddress: String,
    @SerialName("university")
    val university: String,
    @SerialName("bank")
    val bank: Bank,
    @SerialName("company")
    val company: Company,
    @SerialName("ein")
    val ein: String,
    @SerialName("ssn")
    val ssn: String,
    @SerialName("userAgent")
    val userAgent: String
)

@Serializable
data class Hair(
    @SerialName("color")
    val color: String,
    @SerialName("type")
    val type: String
)

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

@Serializable
data class Coordinates(
    @SerialName("lat")
    val lat: Double,
    @SerialName("lng")
    val lng: Double
)

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
