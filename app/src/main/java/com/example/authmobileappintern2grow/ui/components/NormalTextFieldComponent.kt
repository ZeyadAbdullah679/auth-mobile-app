package com.example.authmobileappintern2grow.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.authmobileappintern2grow.R
import com.example.authmobileappintern2grow.ui.theme.AuthMobileAppIntern2GrowTheme

@Composable
fun NormalTextFieldComponent(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType,
    modifier: Modifier = Modifier,
    readOnly: Boolean = false
) {
    Column {
        Text(text = label, style = MaterialTheme.typography.labelSmall)
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
                keyboardType = keyboardType
            ),
            trailingIcon = if (!readOnly) {
                {
                    IconButton(
                        onClick = { onValueChange("") },
                    ) {
                        if (value != "") {
                            Icon(
                                painter = painterResource(id = R.drawable.x),
                                contentDescription = "Clear",
                            )
                        }
                    }
                }
            } else {
                {}
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun NormalTextFieldPreview() {
    AuthMobileAppIntern2GrowTheme {
        var x by remember {
            mutableStateOf("")
        }
        NormalTextFieldComponent("Email", x, { x = it }, KeyboardType.Email)
    }
}