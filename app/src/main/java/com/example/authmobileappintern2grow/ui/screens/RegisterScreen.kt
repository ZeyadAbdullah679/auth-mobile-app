package com.example.authmobileappintern2grow.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.authmobileappintern2grow.R
import com.example.authmobileappintern2grow.ui.PersonDataState
import com.example.authmobileappintern2grow.ui.PersonViewModel
import com.example.authmobileappintern2grow.ui.components.ButtonComponent
import com.example.authmobileappintern2grow.ui.components.NormalTextFieldComponent
import com.example.authmobileappintern2grow.ui.components.PasswordTextFieldComponent
import com.example.authmobileappintern2grow.ui.components.TwoTextComponent
import com.example.authmobileappintern2grow.ui.components.UpperPanel
import com.example.authmobileappintern2grow.ui.theme.AuthMobileAppIntern2GrowTheme

@Composable
fun RegisterScreen(
    viewModel: PersonViewModel,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onRegisterSuccess: () -> Unit,
    onRegisterFail: () -> Unit,
) {
    val uiState = viewModel.uiState.value
    if (viewModel.dataState.value == PersonDataState.Success(uiState)) {
        onRegisterSuccess()
    } else if (viewModel.dataState.value == PersonDataState.Error) {
        onRegisterFail()
    }
    Column(
        Modifier.fillMaxSize()
    ) {
        UpperPanel(header = "Create new account")
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            NormalTextFieldComponent(
                label = "Username",
                value = uiState.username,
                onValueChange = { viewModel.onNameChange(it) },
                keyboardType = KeyboardType.Text
            )
            Spacer(modifier = Modifier.padding(8.dp))
            NormalTextFieldComponent(
                label = "Email",
                value = uiState.email,
                onValueChange = { viewModel.onEmailChange(it) },
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.padding(8.dp))
            PasswordTextFieldComponent(
                value = uiState.password,
                onValueChange = { viewModel.onPasswordChange(it) },
            )
        }
        TwoTextComponent(
            checked = uiState.isRememberMeChecked,
            onCheckedChange = { viewModel.onCheckBoxChange(it) },
            underlineText = R.string.have_a_problem
        )
        ButtonComponent(
            text = R.string.register,
            onClick = onRegisterClick,
            color = Color(0xFF007BFF)
        )
        Box(modifier = Modifier.padding(start = 8.dp)) {
            TwoTextComponent(
                checked = false,
                onCheckedChange = {},
                rememberMe = false,
                underlineText = R.string.login,
                firstText = R.string.already_have_an_account,
                onClickSecondText = onLoginClick,
                horizontalArrangement = Arrangement.Start
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    AuthMobileAppIntern2GrowTheme {
        RegisterScreen(viewModel = PersonViewModel(), {}, {}, {}, {})
    }
}