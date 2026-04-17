package com.style

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val PrimaryColorV2 = Color(0xFF18191A)
val LikeColorV2 = Color(0xFFEF4444)
val SecondaryColorV2 = Color(0xFF94A3B8)
val HintColorV2 = Color(0xFF94A3B8)

val StoryCooperativeHeaderImageUserBackgroundV2
    @Composable get() =
        if (isSystemInDarkTheme()) Color(0xFF565656)
        else Color(0xFFF3F4F6)

val OverlappingImageBorderV2
    @Composable get() =
        if (isSystemInDarkTheme()) MainColor
        else Color.White

val CooperativeScreenContentTextV2
    @Composable get() =
        if (isSystemInDarkTheme()) PrimaryColorV2
        else PrimaryColorV2