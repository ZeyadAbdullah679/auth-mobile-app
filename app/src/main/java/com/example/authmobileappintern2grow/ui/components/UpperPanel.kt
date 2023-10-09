package com.example.authmobileappintern2grow.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.authmobileappintern2grow.R.drawable
import com.example.authmobileappintern2grow.R.string
import com.example.authmobileappintern2grow.ui.theme.AuthMobileAppIntern2GrowTheme

@Composable
fun UpperPanel(
    header: String,
    imageUrl: String = "",
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier.height(240.dp)
        ) {
            Image(
                painter = painterResource(id = drawable.upper_layer),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
            if (imageUrl == "") {
                Image(
                    painter = painterResource(id = drawable.avatar),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(116.dp)
                        .align(Alignment.BottomCenter)
                )
            } else {
                Card(
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .size(116.dp)
                        .align(Alignment.BottomCenter)
                ) {
                    AsyncImage(
                        model = imageUrl,
                        contentDescription = stringResource(string.profile_avatar),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(CircleShape)
                    )
                }
            }
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
        UpperPanel(
            imageUrl = "https://robohash.org/hicveldicta.png?size=50x50&set=set1",
            header = "Log in to your account"
        )
    }
}