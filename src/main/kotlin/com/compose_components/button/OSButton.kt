package com.compose_components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose_components.text.TextMain

@Composable
fun OSButton(
    modifier: Modifier = Modifier,
    text: String,
    startIcon: Int? = null,
    endIcon: Int? = null,
    enabled: Boolean = true,
    buttonType: ButtonType,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = buttonType.colors(),
        shape = RoundedCornerShape(10.dp),
        enabled = enabled,
        border = buttonType.border()
    ) {
        startIcon?.let {
            Image(
                painter = painterResource(it),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        TextMain(
            text = text,
            color = buttonType.textColor(enabled)
        )
        endIcon?.let {
            Image(
                painter = painterResource(it),
                contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Composable
fun OSButtonSmall(
    modifier: Modifier = Modifier,
    text: String? = null,
    startIcon: Int? = null,
    endIcon: Int? = null,
    enabled: Boolean = true,
    buttonType: ButtonType = ButtonType.NORMAL,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(32.dp),
        colors = buttonType.colors(),
        shape = RoundedCornerShape(6.dp),
        enabled = enabled,
        contentPadding = PaddingValues(0.dp),
        border = buttonType.border()
    ) {
        startIcon?.let {
            Icon(
                painter = painterResource(it),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = buttonType.textColor(enabled)
            )
            if (!text.isNullOrEmpty()) {
                Spacer(modifier = Modifier.width(8.dp))
            }
        }

        text?.let {
            TextMain(
                modifier = Modifier.padding(horizontal = 18.dp),
                text = text,
                color = buttonType.textColor(enabled),
                fontSize = 12.sp
            )
        }
        endIcon?.let {
            Icon(
                painter = painterResource(it),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = buttonType.textColor(enabled)
            )
        }
    }
}