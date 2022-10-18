package com.compose_components.icon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.style.dimen16

@Composable
fun IconChanger(
    modifier: Modifier = Modifier,
    onClickListener: () -> Unit,
    iconCondition: Boolean,
    selectedIcon: Int,
    deselectedIcon: Int,
    iconSize: Dp = dimen16,
    contentDescription: String? = null,
) {
    Icon(
        modifier = modifier
            .size(iconSize)
            .clickable { onClickListener.invoke() },
        painter = painterResource(
            if (iconCondition) selectedIcon
            else deselectedIcon
        ),
        contentDescription = contentDescription,
        tint = MaterialTheme.colors.primary
    )
}

@Composable
fun IconClickable(
    modifier: Modifier = Modifier,
    onClickListener: () -> Unit,
    icon: Int,
    iconSize: Dp = dimen16,
    contentDescription: String? = null,
    iconTint: Color = MaterialTheme.colors.primary,
) {
    Icon(
        modifier = modifier
            .size(iconSize)
            .clickable { onClickListener.invoke() },
        painter = painterResource(icon),
        contentDescription = contentDescription,
        tint = iconTint
    )
}