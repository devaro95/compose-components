package com.compose_components.icon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.style.IconPrimary
import com.style.dimen20
import com.style.dimen24

@Composable
fun IconChanger(
    modifier: Modifier = Modifier,
    onClickListener: () -> Unit,
    iconCondition: Boolean,
    selectedIcon: Int,
    deselectedIcon: Int,
    iconSize: Dp = dimen20,
    contentDescription: String? = null,
) {
    Icon(
        modifier = modifier
            .size(iconSize)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClickListener.invoke() }),
        painter = painterResource(
            if (iconCondition) selectedIcon
            else deselectedIcon
        ),
        contentDescription = contentDescription,
        tint = IconPrimary
    )
}

@Composable
fun IconClickable(
    modifier: Modifier = Modifier,
    onClickListener: () -> Unit,
    icon: Int,
    iconSize: Dp = dimen20,
    contentDescription: String? = null,
    iconTint: Color = IconPrimary,
) {
    Icon(
        modifier = modifier
            .size(iconSize)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
                onClick = { onClickListener.invoke() }),
        painter = painterResource(icon),
        contentDescription = contentDescription,
        tint = iconTint
    )
}