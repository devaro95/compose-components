package com.compose_components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.compose_components.text.TextMain
import com.style.*

@Preview
@Composable
fun CardButtonPreview() {
    CardButton(
        text = "esto es el label",
        icon = 1
    )
}

@Composable
fun CardButton(
    text: String,
    colors: CardColors = CardColorsDefaults,
    elevation: Dp = dimen8,
    contentPadding: Dp = dimen16,
    cornerRadius: Dp = cornersRadius,
    icon: Int,
    iconSize: Dp = dimen20,
    onIconClick: (() -> Unit)? = null,
) {
    Card(
        shape = RoundedCornerShape(cornerRadius),
        modifier = Modifier
            .padding(end = dimen8)
            .fillMaxWidth(),
        colors = colors,
        elevation = CardDefaults.cardElevation(elevation)
    ) {
        Column(modifier = Modifier.padding(contentPadding)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextMain(text = text)
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(iconSize)
                            .clickable { onIconClick?.invoke() },
                        tint = MainColor
                    )
                }
            }
        }
    }
}