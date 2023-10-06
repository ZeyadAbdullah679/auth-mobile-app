package com.example.authmobileappintern2grow.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.authmobileappintern2grow.R

@Composable
fun TwoTextComponent(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    @StringRes underlineText: Int,
    @StringRes firstText: Int = R.string.dont_have_an_account,
    rememberMe: Boolean = true,
    onClickSecondText: () -> Unit = {},
    horizontalArrangement: Arrangement.Horizontal = Arrangement.SpaceBetween,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = horizontalArrangement
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (rememberMe) {
                Checkbox(
                    checked = checked,
                    onCheckedChange = onCheckedChange,
                )
                Text(
                    text = stringResource(R.string.remember_me),
                    style = MaterialTheme.typography.labelLarge
                )
            } else {
                Text(
                    text = stringResource(firstText),
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontFamily = FontFamily(Font(R.font.inter_regular)),
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.padding(2.dp))
            }
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(underlineText),
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier
                    .clickable { onClickSecondText() }
                    .background(Color.Transparent)
                    .drawWithContent {
                        drawContent()
                        drawLine(
                            color = Color(0xFF4F90F0),
                            strokeWidth = 1.5.dp.toPx(),
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height)
                        )
                    }
            )
        }
    }
}