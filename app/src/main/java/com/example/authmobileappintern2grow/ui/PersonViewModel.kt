package com.example.authmobileappintern2grow.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PersonViewModel : ViewModel() {
    private val _uiState = mutableStateOf(PersonUiState("", "", ""))
    val uiState: MutableState<PersonUiState> = _uiState

    fun onNameChange(username: String) {
        uiState.value = uiState.value.copy(username = username)
    }

    fun onPasswordChange(password: String) {
        uiState.value = uiState.value.copy(password = password)
    }

    fun onEmailChange(email: String) {
        uiState.value = uiState.value.copy(email = email)
    }

    fun onCheckBoxChange(isChecked: Boolean) {
        uiState.value = uiState.value.copy(isRememberMeChecked = isChecked)
    }

}