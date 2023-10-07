package com.example.authmobileappintern2grow.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authmobileappintern2grow.network.AuthApi
import com.example.authmobileappintern2grow.network.request.LoginUserRequest
import com.example.authmobileappintern2grow.network.request.RegisterUserRequest
import com.example.authmobileappintern2grow.network.response.register.RegisterUserResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class PersonViewModel : ViewModel() {

    private val _uiState: MutableState<PersonUiState> = mutableStateOf(PersonUiState("", "", ""))
    val uiState: MutableState<PersonUiState> = _uiState

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

    fun onRegisterClick(): Boolean {
        var response: RegisterUserResponse? = null
        val request = RegisterUserRequest(
            username = uiState.value.username,
            password = uiState.value.password,
            email = uiState.value.email
        )
        viewModelScope.launch {
            try {
                response = AuthApi.retrofitService.addUser(request)
            } catch (e: Exception) {
                Log.d("PersonViewModel1", "onRegisterClick: ${e.message}")
            }
        }
        return if (response != null) {
            _uiState.value = _uiState.value.copy(
                username = response!!.username,
                password = response!!.password,
                email = response!!.email
            )
            true
        } else {
            false
        }
    }

    fun onLoginClick() {
        val request = LoginUserRequest(
            username = _uiState.value.username,
            password = _uiState.value.password
        )
        viewModelScope.launch {
            try {
                val responseDeferred = async {
                    AuthApi.retrofitService.login(request)
                }

                val response = responseDeferred.await()
                _uiState.value = _uiState.value.copy(
                    username = response.username,
                    email = response.email,
                    isLogin = true
                )
            } catch (e: Exception) {
                Log.d("PersonViewModel1", "onLoginClick: ${e.message}")
            }
        }
    }

    fun reset() {
        _uiState.value = PersonUiState("", "", "")
    }

}