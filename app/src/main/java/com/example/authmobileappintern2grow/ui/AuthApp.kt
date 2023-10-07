package com.example.authmobileappintern2grow.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class AuthScreens {
    Login,
    Register,
    Profile
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthApp(
    navController: NavHostController = rememberNavController(),
    viewModel: PersonViewModel = PersonViewModel()
) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AuthScreens.Login.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AuthScreens.Login.name) {
                LoginScreen(
                    viewModel = viewModel,
                    onRegisterClick = { navController.navigate(AuthScreens.Register.name) },
                    onLoginClick = { /*TODO*/ }
                )
            }
            composable(AuthScreens.Register.name) {
                RegisterScreen(
                    viewModel = viewModel,
                    onLoginClick = { navController.navigate(AuthScreens.Login.name) },
                    onRegisterClick = { /*TODO*/ }
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
