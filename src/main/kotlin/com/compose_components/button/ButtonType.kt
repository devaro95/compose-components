package com.compose_components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.style.ButtonDisabledTextColor
import com.style.ButtonSecondaryColor
import com.style.ButtonTextColor
import com.style.InputBorderColor
import com.style.OSButtonDefault
import com.style.OSButtonSecondaryDefault

enum class ButtonType(
    val colors: @Composable () -> ButtonColors,
    val border: @Composable () -> BorderStroke?,
    val textColor: @Composable (enabled: Boolean) -> Color,
) {
    NORMAL(
        colors = { OSButtonDefault },
        border = { null },
        textColor = { if (it) ButtonTextColor else ButtonDisabledTextColor }
    ),
    SECONDARY(
        colors = { OSButtonSecondaryDefault },
        border = { BorderStroke(1.dp, InputBorderColor) },
        textColor = { ButtonSecondaryColor }
    )

}