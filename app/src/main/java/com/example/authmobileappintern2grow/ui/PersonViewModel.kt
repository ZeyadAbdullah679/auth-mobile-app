package com.example.authmobileappintern2grow.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authmobileappintern2grow.network.AuthApi
import com.example.authmobileappintern2grow.network.request.DummyRegister
import com.example.authmobileappintern2grow.network.request.LoginUserRequest
import kotlinx.coroutines.launch

sealed interface PersonDataState {
    data class Success(val data: PersonUiState) : PersonDataState
    object Error : PersonDataState
    object Loading : PersonDataState
    object Empty : PersonDataState
}

class PersonViewModel : ViewModel() {

    private val _uiState: MutableState<PersonUiState> = mutableStateOf(
        PersonUiState("", "", "", "male", "")
    )
    val uiState: MutableState<PersonUiState> = _uiState

    private val _dataState: MutableState<PersonDataState> = mutableStateOf(PersonDataState.Empty)
    val dataState: MutableState<PersonDataState> = _dataState

    init {
        reset()
    }

    fun onNameChange(username: String) {
        _uiState.value = _uiState.value.copy(username = username)
    }

    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(password = password)
    }

    fun onEmailChange(email: String) {
        _uiState.value = _uiState.value.copy(email = email)
    }

    fun onCheckBoxChange(isChecked: Boolean) {
        _uiState.value = _uiState.value.copy(isRememberMeChecked = isChecked)
    }

    fun onRegisterClick() {
        val request = DummyRegister.registerUserRequest.copy(
            username = _uiState.value.username,
            email = _uiState.value.email,
            password = _uiState.value.password
        )
        Log.d("PersonViewModel1", "Request: ${request.age}")
        _dataState.value = PersonDataState.Loading
        viewModelScope.launch {
            try {
                val response = AuthApi.retrofitService.addUser(request)
                _uiState.value = _uiState.value.copy(
                    username = response.username,
                    email = response.email,
                    password = response.password,
                )
                _dataState.value = PersonDataState.Success(_uiState.value)
            } catch (e: Exception) {
                _dataState.value = PersonDataState.Error
            }
        }
    }

    fun onLoginClick() {
        val request = LoginUserRequest(
            username = _uiState.value.username,
            password = _uiState.value.password
        )
        _dataState.value = PersonDataState.Loading
        viewModelScope.launch {
            try {
                val response = AuthApi.retrofitService.login(request)
                _uiState.value = _uiState.value.copy(
                    username = response.username,
                    email = response.email,
                    gender = response.gender,
                    image = response.image,
                )
                _dataState.value = PersonDataState.Success(_uiState.value)
            } catch (e: Exception) {
                _dataState.value = PersonDataState.Error
            }
        }
    }

    fun reset() {
        _uiState.value = PersonUiState("", "", "", "male", "")
        _dataState.value = PersonDataState.Empty
    }

}