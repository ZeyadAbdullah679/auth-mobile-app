package com.example.authmobileappintern2grow.ui

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class AuthScreens {
    Login,
    Register,
    Profile
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
            startDestination = AuthScreens.Login.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AuthScreens.Login.name) {
                LoginScreen(
                    viewModel = viewModel,
                    onRegisterClick = {
                        navController.navigate(AuthScreens.Register.name)
                        viewModel.reset()
                    },
                    onLoginClick = {
                        viewModel.onLoginClick()
                        if (viewModel.uiState.value.isLogin) {
                            navController.navigate(AuthScreens.Profile.name)
                        } else {
                            Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT)
                                .show()
                        }
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
                        val check = viewModel.onRegisterClick()
                        if (check) {
                            navController.navigate(AuthScreens.Login.name)
                        } else {
                            Toast.makeText(
                                context,
                                "${viewModel.uiState.value}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                )
            }
            composable(AuthScreens.Profile.name) {
                ProfileScreen(
                    viewModel = viewModel,
                    onClickLogout = { /*TODO*/ }
                )
            }
        }
    }
}