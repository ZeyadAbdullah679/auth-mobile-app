package com.example.authmobileappintern2grow.ui.theme


import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.authmobileappintern2grow.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyMedium = TextStyle(
        fontSize = 20.sp,
        fontFamily = FontFamily(Font(R.font.inter_bold)) ,
        fontWeight = FontWeight(700),
        color = Color(0xFF2A2B2E),
        textAlign = TextAlign.Center,
    ),

    labelSmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight = FontWeight(400),
        color = Color(0xFF808194),
    ),

    displaySmall = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.inter_regular)),
        fontWeight = FontWeight(400),
        color = Color(0xFF2A2B2E),
    ),

    displayMedium = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.inter_bold)),
        fontWeight = FontWeight(700),
        color = Color(0xFF2A2B2E),
    ),

    labelMedium =  TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.inter_bold)),
        fontWeight = FontWeight(700),
        color = Color(0xFFFFFFFF),
        textAlign = TextAlign.Center,
    ),
)