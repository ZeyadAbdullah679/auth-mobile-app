package com.example.authmobileappintern2grow.ui

data class PersonUiState(
    val username: String,
    val email: String,
    val password: String,
    val gender: String = "Male",
    val image: String,
    val isRememberMeChecked: Boolean = false,
)
