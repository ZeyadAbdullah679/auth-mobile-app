package com.example.authmobileappintern2grow.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.authmobileappintern2grow.R
import com.example.authmobileappintern2grow.ui.theme.AuthMobileAppIntern2GrowTheme

@Composable
fun ButtonComponent(
    @StringRes text: Int,
    onClick: () -> Unit,
    color: Color,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ) {
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.labelMedium
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    AuthMobileAppIntern2GrowTheme {
        ButtonComponent(text = R.string.login, onClick = { /*TODO*/ }, Color.Red)
    }
}