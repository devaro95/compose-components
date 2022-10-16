package com.compose_components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.compose_components.text.TextMain
import com.style.cornersRadius
import com.style.dimen16
import com.style.dimen20
import com.style.dimen8

@Preview
@Composable
fun CardButtonPreview() {
    CardButton(
        text = "esto es el label",
        backgroundColor = Color.White,
        icon = 1
    )
}

@Composable
fun CardButton(
    text: String,
    backgroundColor: Color = Color.White,
    elevation: Dp = dimen8,
    contentPadding: Dp = dimen16,
    cornerRadius: Dp = cornersRadius,
    icon: Int,
    iconSize: Dp = dimen20,
    onIconClick: (() -> Unit)? = null
) {
    Card(
        shape = RoundedCornerShape(cornerRadius),
        modifier = Modifier
            .padding(end = dimen8)
            .fillMaxWidth(),
        backgroundColor = backgroundColor,
        elevation = elevation
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
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        }
    }
}