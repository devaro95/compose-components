package com.compose_components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.SwitchColors
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.compose_components.R
import com.compose_components.text.TextMain
import com.style.GreyColor
import com.style.dimen10
import com.style.dimen16
import com.style.dimen20
import com.style.dimen8

@Preview
@Composable
fun CardIconStartPreview() {
    CardIcon(label = "Label", icon = R.drawable.ic_open_book)
}

@Preview
@Composable
fun CardIconSwitchPreview() {
    CardIconSwitch(label = "Label", icon = R.drawable.ic_open_book, isChecked = true, onChangeListener = {})
}

@Composable
fun CardIcon(
    modifier: Modifier = Modifier,
    label: String,
    icon: Int,
    textColor: Color = MaterialTheme.colors.primary,
    iconTint: Color = MaterialTheme.colors.primary,
    onClickListener: (() -> Unit)? = null,
) {
    Card(
        shape = RoundedCornerShape(dimen10),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClickListener?.invoke() },
        elevation = dimen8) {
        Column(modifier = Modifier.padding(dimen16)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(dimen20),
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = iconTint
                )
                TextMain(
                    modifier = Modifier.padding(start = dimen16),
                    text = label,
                    color = textColor)
            }
        }
    }
}

@Composable
fun CardIconSwitch(
    modifier: Modifier = Modifier,
    label: String,
    icon: Int,
    iconTint: Color = MaterialTheme.colors.primary,
    textColor: Color = MaterialTheme.colors.primary,
    isChecked: Boolean,
    onChangeListener: ((Boolean) -> Unit)? = null,

    switchColors: SwitchColors? = null,
) {
    Card(
        shape = RoundedCornerShape(dimen10),
        modifier = modifier
            .fillMaxWidth(),
        elevation = dimen8
    ) {
        Column(modifier = Modifier.padding(horizontal = dimen16)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    modifier = Modifier.size(dimen20),
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = iconTint
                )
                TextMain(
                    modifier = Modifier
                        .padding(start = dimen16)
                        .weight(9f),
                    text = label,
                    color = textColor,
                    maxLines = 1)
                Switch(
                    modifier = Modifier.weight(1f),
                    checked = isChecked,
                    onCheckedChange = { onChangeListener?.invoke(it) },
                    colors = switchColors ?: SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colors.primary,
                        uncheckedThumbColor = MaterialTheme.colors.primary,
                        uncheckedTrackColor = GreyColor
                    )
                )
            }
        }
    }
}