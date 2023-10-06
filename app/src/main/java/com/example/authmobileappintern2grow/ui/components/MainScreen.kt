package com.example.authmobileappintern2grow.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.authmobileappintern2grow.R
import com.example.authmobileappintern2grow.ui.theme.AuthMobileAppIntern2GrowTheme

@Composable
fun MainScreen(
    @DrawableRes headerAvatar: Int,
    header: String,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.height(240.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.upper_layer),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Image(
                painter = painterResource(id = headerAvatar),
                contentDescription = "Avatar",
                modifier = Modifier
                    .size(116.dp)
                    .align(Alignment.BottomCenter)
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Text(text = header, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AuthMobileAppIntern2GrowTheme {
        MainScreen(headerAvatar = R.drawable.avatar, header = "Log in to your account")
    }
}