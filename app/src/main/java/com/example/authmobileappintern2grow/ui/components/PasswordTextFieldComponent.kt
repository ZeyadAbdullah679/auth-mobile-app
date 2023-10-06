package com.example.authmobileappintern2grow.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.authmobileappintern2grow.R
import com.example.authmobileappintern2grow.ui.theme.AuthMobileAppIntern2GrowTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    readOnly: Boolean = false
) {
    var showPass by remember {
        mutableStateOf(true)
    }
    Column {
        Text(text = "Password", style = MaterialTheme.typography.labelSmall)
        Spacer(modifier = Modifier.padding(4.dp))
        OutlinedTextField(
            value = value,
            textStyle = MaterialTheme.typography.displaySmall,
            onValueChange = onValueChange,
            modifier = modifier
                .fillMaxWidth(),
            singleLine = true,
            maxLines = 1,
            readOnly = readOnly,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if(showPass) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = {
                IconButton(
                    onClick = { showPass = !showPass },
                ) {
                    if(showPass)
                        Icon(painter = painterResource(id = R.drawable.clarity_eye_hide_line), contentDescription = "Hide Password")
                    else
                        Icon(painter = painterResource(id = R.drawable.clarity_eye_show_line), contentDescription = "Show Password")
                }
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PasswordTextFieldPreview() {
    AuthMobileAppIntern2GrowTheme {
        var x by remember {
            mutableStateOf("")
        }
        PasswordTextFieldComponent(x, { x = it })
    }
}