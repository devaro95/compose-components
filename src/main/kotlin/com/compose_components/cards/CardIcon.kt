package com.compose_components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.compose_components.R
import com.compose_components.text.TextMain
import com.style.*

@Preview
@Composable
fun CardIconStartPreview() {
    CardIcon(label = "Card Label", icon = R.drawable.ic_open_book)
}

@Preview
@Composable
fun CardIconSwitchPreview() {
    CardIconSwitch(label = "Card Label", icon = R.drawable.ic_open_book, isChecked = true, onChangeListener = {})
}

/**
Customizable Card with a start icon.
@param modifier Modifier for the card.
@param label Label text to show.
@param icon Start icon.
@param iconSize Start icon height and width.
@param elevation Card elevation
@param contentPadding Padding between card, content and card border.
@param textSeparation Padding between text and icon.
@param cornerRadius Card radius
@param textColor Color of label text.
@param iconTint Color of icon.
@param onClickListener Listener for card when clicking.
 **/

@Composable
fun CardIcon(
    modifier: Modifier = Modifier,
    label: String,
    icon: Int,
    iconSize: Dp = dimen20,
    elevation: Dp = dimen8,
    contentPadding: Dp = dimen16,
    textSeparation: Dp = dimen16,
    cornerRadius: Dp = cornersRadius,
    textColor: Color = MainColor,
    iconTint: Color = MainColor,
    onClickListener: (() -> Unit)? = null,
    contentDescription: String? = null,
    fontWeight: FontWeight = FontWeight.Normal,
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
                    modifier = Modifier.size(iconSize),
                    painter = painterResource(id = icon),
                    contentDescription = contentDescription,
                    tint = iconTint
                )
                TextMain(
                    modifier = Modifier.padding(start = textSeparation),
                    text = label,
                    color = textColor,
                    fontWeight = fontWeight
                )
            }
        }
    }
}

/**
Customizable Card with a start icon and a switch.
@param modifier Modifier for the card.
@param label Label text to show.
@param icon Start icon.
@param iconSize Start icon height and width.
@param elevation Card elevation
@param contentPadding Padding between card content and card border.
@param textSeparation Padding between text and icon.
@param cornerRadius Card radius
@param textColor Color of label text.
@param iconTint Color of icon.
@param isChecked Switch selected state.
@param switchColors Colors for switch.
@param maxLines Number of label lines.
@param onChangeListener Switch click action.
 **/

@Composable
fun CardIconSwitch(
    modifier: Modifier = Modifier,
    label: String,
    icon: Int,
    iconSize: Dp = dimen20,
    elevation: Dp = dimen8,
    contentPadding: Dp = dimen16,
    textSeparation: Dp = dimen16,
    cornerRadius: Dp = cornersRadius,
    textColor: Color = MainColor,
    iconTint: Color = MainColor,
    isChecked: Boolean,
    switchColors: SwitchColors? = null,
    maxLines: Int = 1,
    onChangeListener: ((Boolean) -> Unit)? = null,
    contentDescription: String? = null,
) {
    Card(
        shape = RoundedCornerShape(cornerRadius),
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(elevation),
        colors = CardColorsDefaults
    ) {
        Column(modifier = Modifier.padding(horizontal = contentPadding)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    modifier = Modifier.size(iconSize),
                    painter = painterResource(id = icon),
                    contentDescription = contentDescription,
                    tint = iconTint
                )
                TextMain(
                    modifier = Modifier
                        .padding(horizontal = textSeparation)
                        .weight(9f),
                    text = label,
                    color = textColor,
                    maxLines = maxLines
                )
                Column(
                    modifier = Modifier
                        .weight(1f),
                ) {
                    Switch(
                        modifier = Modifier
                            .scale(scaleX = 0.7f, scaleY = 0.7f)
                            .padding(end = 16.dp),
                        checked = isChecked,
                        onCheckedChange = { onChangeListener?.invoke(it) },
                        colors = switchColors ?: SwitchDefaults.colors(
                            checkedTrackColor = SecondaryColor,
                            checkedThumbColor = MainColor,
                            uncheckedThumbColor = MainColor,
                            uncheckedTrackColor = SwitchDisabled,
                            checkedBorderColor = MainColor,
                            uncheckedBorderColor = MainColor,
                        )
                    )
                }
            }
        }
    }
}