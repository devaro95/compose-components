package com.compose_components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.compose_components.text.TextMain
import com.style.*

@Composable
fun OSButton(
    modifier: Modifier = Modifier,
    text: String,
    startIcon: Int? = null,
    endIcon: Int? = null,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = OSButtonDefault,
        shape = RoundedCornerShape(10.dp),
        enabled = enabled
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
            color = if(enabled) ButtonTextColor else ButtonDisabledTextColor
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
fun OSButtonSecondary(
    modifier: Modifier = Modifier,
    text: String,
    startIcon: Int? = null,
    endIcon: Int? = null,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = OSButtonSecondaryDefault,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, InputBorderColor),
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
            color = ButtonSecondaryColor
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