package com.example.authmobileappintern2grow.network.response.register


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RegisterUserResponse(
    @SerialName("address")
    val address: Address,
    @SerialName("age")
    val age: Int,
    @SerialName("bank")
    val bank: Bank,
    @SerialName("birthDate")
    val birthDate: String,
    @SerialName("bloodGroup")
    val bloodGroup: String,
    @SerialName("company")
    val company: Company,
    @SerialName("domain")
    val domain: String,
    @SerialName("ein")
    val ein: String,
    @SerialName("email")
    val email: String,
    @SerialName("eyeColor")
    val eyeColor: String,
    @SerialName("firstName")
    val firstName: String,
    @SerialName("gender")
    val gender: String,
    @SerialName("hair")
    val hair: Hair,
    @SerialName("height")
    val height: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("ip")
    val ip: String,
    @SerialName("lastName")
    val lastName: String,
    @SerialName("macAddress")
    val macAddress: String,
    @SerialName("maidenName")
    val maidenName: String,
    @SerialName("password")
    val password: String,
    @SerialName("phone")
    val phone: String,
    @SerialName("ssn")
    val ssn: String,
    @SerialName("university")
    val university: String,
    @SerialName("userAgent")
    val userAgent: String,
    @SerialName("username")
    val username: String,
    @SerialName("weight")
    val weight: Double
)