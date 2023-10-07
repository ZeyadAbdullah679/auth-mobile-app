package com.example.authmobileappintern2grow.ui

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
import com.example.authmobileappintern2grow.ui.components.ButtonComponent
import com.example.authmobileappintern2grow.ui.components.NormalTextFieldComponent
import com.example.authmobileappintern2grow.ui.components.PasswordTextFieldComponent
import com.example.authmobileappintern2grow.ui.components.TwoTextComponent
import com.example.authmobileappintern2grow.ui.components.UpperPanel
import com.example.authmobileappintern2grow.ui.theme.AuthMobileAppIntern2GrowTheme

@Composable
fun LoginScreen(
    viewModel: PersonViewModel,
    onRegisterClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    val uiState = viewModel.uiState.value
    Column(
        Modifier.fillMaxSize()
    ) {
        UpperPanel(headerAvatar = R.drawable.avatar, header = "Log in to your account")
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
            PasswordTextFieldComponent(
                value = uiState.password,
                onValueChange = { viewModel.onPasswordChange(it) },
            )
        }
        TwoTextComponent(
            checked = uiState.isRememberMeChecked,
            onCheckedChange = { viewModel.onCheckBoxChange(it) },
            underlineText = R.string.forgot_password
        )
        ButtonComponent(text = R.string.login, onClick = { /*TODO*/ }, color = Color(0xFF007BFF))
        Box(modifier = Modifier.padding(start = 8.dp)) {
            TwoTextComponent(
                checked = false,
                onCheckedChange = {},
                rememberMe = false,
                underlineText = R.string.register,
                onClickSecondText = onRegisterClick,
                horizontalArrangement = Arrangement.Start
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AuthMobileAppIntern2GrowTheme {
        LoginScreen(viewModel = PersonViewModel(), { }, { })
    }
}