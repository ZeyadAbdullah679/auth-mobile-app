package com.example.authmobileappintern2grow.ui

data class PersonUiState(
    val username: String,
    val email: String,
    val password: String,
    val gender: String = "Male",
    val isRememberMeChecked: Boolean = false,
    val isLogin: Boolean = false,
    val isRegister: Boolean = false
)
