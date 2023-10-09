package com.example.authmobileappintern2grow

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.authmobileappintern2grow.ui.AppPreferences
import com.example.authmobileappintern2grow.ui.PersonDataState
import com.example.authmobileappintern2grow.ui.PersonUiState
import com.example.authmobileappintern2grow.ui.PersonViewModel
import com.example.authmobileappintern2grow.ui.screens.ErrorScreen
import com.example.authmobileappintern2grow.ui.screens.LoginScreen
import com.example.authmobileappintern2grow.ui.screens.ProfileScreen
import com.example.authmobileappintern2grow.ui.screens.RegisterScreen

enum class AuthScreens {
    Login,
    Register,
    Profile,
    Error
}

@Composable
fun AuthApp(
    navController: NavHostController = rememberNavController(),
    viewModel: PersonViewModel = PersonViewModel()
) {
    val context = LocalContext.current
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = if (isInternetAvailable(context)) {
                if (AppPreferences(context).getObject("user", PersonUiState::class.java) != null) {
                    viewModel.uiState.value =
                        AppPreferences(context).getObject("user", PersonUiState::class.java)
                    AuthScreens.Profile.name
                } else {
                    AuthScreens.Login.name
                }
            } else {
                AuthScreens.Error.name
            },
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AuthScreens.Error.name) {
                ErrorScreen(
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable(AuthScreens.Login.name) {
                LoginScreen(
                    viewModel = viewModel,
                    onRegisterClick = {
                        navController.navigate(AuthScreens.Register.name)
                        viewModel.reset()
                    },
                    onLoginClick = {
                        viewModel.onLoginClick()
                    },
                    onLoginSuccess = {
                        navController.navigate(AuthScreens.Profile.name)
                        viewModel.dataState.value = PersonDataState.Empty
                        if (viewModel.uiState.value.isRememberMeChecked)
                            AppPreferences(context).putObject("user", viewModel.uiState.value)
                    },
                    onLoginFail = {
                        Toast.makeText(context, "Login Fail", Toast.LENGTH_SHORT).show()
                    }
                )
            }
            composable(AuthScreens.Register.name) {
                RegisterScreen(
                    viewModel = viewModel,
                    onLoginClick = {
                        navController.navigate(AuthScreens.Login.name)
                        viewModel.reset()
                    },
                    onRegisterClick = {
                        viewModel.onRegisterClick()
                    },
                    onRegisterSuccess = {
                        navController.navigate(AuthScreens.Profile.name)
                        viewModel.dataState.value = PersonDataState.Empty
                    },
                    onRegisterFail = {
                        Toast.makeText(context, "Register Failed", Toast.LENGTH_SHORT).show()
                    }
                )
            }
            composable(AuthScreens.Profile.name) {
                ProfileScreen(
                    viewModel = viewModel,
                    onClickLogout = {
                        viewModel.reset()
                        navController.navigate(AuthScreens.Login.name)
                        AppPreferences(context).removeObject("user")
                    }
                )
            }
        }
    }
}

fun isInternetAvailable(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val network = connectivityManager.activeNetwork
    if (network != null) {
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network)
        return networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            ?: false
    }

    return false
}