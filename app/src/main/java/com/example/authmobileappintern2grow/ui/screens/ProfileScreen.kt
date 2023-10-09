package com.example.authmobileappintern2grow.ui.screens

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
import com.example.authmobileappintern2grow.ui.PersonViewModel
import com.example.authmobileappintern2grow.ui.components.ButtonComponent
import com.example.authmobileappintern2grow.ui.components.NormalTextFieldComponent
import com.example.authmobileappintern2grow.ui.components.UpperPanel
import com.example.authmobileappintern2grow.ui.theme.AuthMobileAppIntern2GrowTheme

@Composable
fun ProfileScreen(viewModel: PersonViewModel, onClickLogout: () -> Unit) {
    val uiState = viewModel.uiState.value
    Column(
        Modifier.fillMaxSize()
    ) {
        UpperPanel(imageUrl = uiState.image, header = uiState.username)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            NormalTextFieldComponent(
                label = "Username",
                value = uiState.username,
                onValueChange = { },
                readOnly = true,
                keyboardType = KeyboardType.Text
            )
            Spacer(modifier = Modifier.padding(8.dp))
            NormalTextFieldComponent(
                label = "Email",
                value = uiState.email,
                onValueChange = { },
                readOnly = true,
                keyboardType = KeyboardType.Email
            )
            Spacer(modifier = Modifier.padding(8.dp))
            NormalTextFieldComponent(
                label = "Gender",
                value = uiState.gender,
                onValueChange = { },
                readOnly = true,
                keyboardType = KeyboardType.Email,
            )
        }
        ButtonComponent(text = R.string.logout, onClick = onClickLogout, color = Color(0xFFDC3545))
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    AuthMobileAppIntern2GrowTheme {
        ProfileScreen(viewModel = PersonViewModel()) { /*TODO*/ }
    }
}