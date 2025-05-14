package com.style

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val PrimaryColor = Color(0xFF18191A)
val AlternativeColor = Color(0xFF242526)

val TextAlternative = Color(0xFF464646)
val TextError = Color(0xFFA53C3C)
val InputBorderColor @Composable get() = MainColor
val IconPrimary @Composable get() = MainColor
val BackgroundColor2 = Color.White
val DarkBackgroundColor = Color(0xFF18191A)
val DarkMainColor = Color.White
val SkeletonColor = Color(0xFFB0BEC5)

val DisabledColor = Color(0xFF2C2D2E)
val DisabledLightColor = Color(0xFFF2F2F2)

val DisabledText = Color(0xFF7A7A7A)
val DisabledLightText = Color(0xFFB0B0B0)

val MainColor
    @Composable get() =
        if (isSystemInDarkTheme()) Color.White
        else Color(0xFF18191A)

val SecondaryColor
    @Composable get() =
        if (isSystemInDarkTheme()) Color(0xFF18191A)
        else Color.White

val TextPrimary
    @Composable get() =
        if (isSystemInDarkTheme()) Color.White
        else PrimaryColor

val TextSecondary
    @Composable get() =
        if (isSystemInDarkTheme()) PrimaryColor
        else Color.White

val ButtonTextColor
    @Composable get() =
        if (isSystemInDarkTheme()) Color(0xFF18191A)
        else Color.White

val DisabledContainerColor
    @Composable get() =
        if (isSystemInDarkTheme()) DisabledColor
        else DisabledLightColor

val DisabledTextColor
    @Composable get() =
        if (isSystemInDarkTheme()) DisabledText
        else DisabledLightText

val ButtonDisabledTextColor
    @Composable get() =
        if (isSystemInDarkTheme()) DisabledText
        else Color.White

val ButtonSecondaryColor
    @Composable get() =
        if (isSystemInDarkTheme()) Color.White
        else Color(0xFF18191A)

val SwitchDisabled
    @Composable get() =
        if (isSystemInDarkTheme()) Color(0xFF8E8E8E)
        else Color(0xFFDBDBDB)

val GreyColor
    @Composable get() =
        if (isSystemInDarkTheme()) Color(0xFFD1D1D1)
        else Color(0xFF464646)

val CardContainerColor
    @Composable get() =
        if (isSystemInDarkTheme()) AlternativeColor
        else Color.White

val BottomSheetBackgroundColor
    @Composable get() =
        if (isSystemInDarkTheme()) AlternativeColor
        else Color.White

val OSButtonDefault
    @Composable get() = ButtonDefaults.buttonColors(
        containerColor = if (isSystemInDarkTheme()) Color.White else PrimaryColor,
        contentColor = if (isSystemInDarkTheme()) PrimaryColor else Color.White,
        disabledContainerColor = DisabledContainerColor,
        disabledContentColor = DisabledTextColor
    )

val OSButtonSecondaryDefault
    @Composable get() = ButtonDefaults.buttonColors(
        containerColor = if (isSystemInDarkTheme()) PrimaryColor else Color.White,
        contentColor = if (isSystemInDarkTheme()) Color.White else PrimaryColor,
    )

val inputColorsDefault
    @Composable get() = TextFieldDefaults.colors(
        focusedTextColor = TextPrimary,
        focusedContainerColor = Color.Transparent,
        errorContainerColor = Color.Transparent,
        disabledContainerColor = Color.Transparent,
        unfocusedContainerColor = Color.Transparent
    )

val CardColorsDefaults
    @Composable get() = CardDefaults.cardColors(
        containerColor = CardContainerColor
    )
