package com.compose_components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.compose_components.R
import com.compose_components.text.TextMain
import com.style.*

@Preview
@Composable
fun CardIconNavigationPreview() {
    CardIconNavigation(label = "Label", icon = R.drawable.ic_open_book)
}

@Preview
@Composable
fun CardIconNavigationMessagePreview() {
    CardIconNavigation(label = "Titulo", message = "Mensaje de la tarjeta", icon = R.drawable.ic_open_book)
}

/**
Customizable Card with a start icon.
@param modifier Modifier for the card.
@param label Title text to show.
@param message Message text to show.
@param icon Start icon.
@param startIconSize Start icon height and width.
@param endIconSize End icon height and width.
@param elevation Card elevation
@param contentPadding Padding between card, content and card border.
@param textSeparation Padding between text and icon.
@param cornerRadius Card radius
@param textColor Color of title text.
@param messageColor Color of message text.
@param startIconTint Color of start icon.
@param endIconTint Color of end icon.
@param onClickListener Listener for card when clicking.
 **/

@Composable
fun CardIconNavigation(
    modifier: Modifier = Modifier,
    label: String,
    message: String? = null,
    icon: Int,
    startIconSize: Dp = dimen20,
    endIconSize: Dp = dimen20,
    elevation: Dp = dimen8,
    contentPadding: Dp = dimen16,
    textSeparation: Dp = dimen16,
    cornerRadius: Dp = cornersRadius,
    textColor: Color = MainColor,
    messageColor: Color = MainColor,
    startIconTint: Color = MainColor,
    endIconTint: Color = MainColor,
    onClickListener: (() -> Unit)? = null,
    startIconContentDescription: String? = null,
    endIconContentDescription: String? = null,
    titleFontWeight: FontWeight = FontWeight.Bold,
) {
    Card(
        shape = RoundedCornerShape(cornerRadius),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClickListener?.invoke() },
        elevation = CardDefaults.cardElevation(elevation),
        colors = CardColorsDefaults
    ) {
        Column(modifier = Modifier.padding(contentPadding)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(startIconSize),
                    painter = painterResource(id = icon),
                    contentDescription = startIconContentDescription,
                    tint = startIconTint
                )
                Column(modifier = Modifier
                    .padding(horizontal = textSeparation)
                    .weight(9f)) {
                    TextMain(
                        text = label,
                        color = textColor,
                        fontWeight = titleFontWeight
                    )
                    if (message != null) {
                        TextMain(
                            text = message,
                            color = messageColor
                        )
                    }
                }
                Icon(
                    modifier = Modifier
                        .size(endIconSize)
                        .weight(1f),
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = endIconContentDescription,
                    tint = endIconTint
                )
            }
        }
    }
}