package com.compose_components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.compose_components.text.TextMain
import com.style.*

@Preview
@Composable
fun CardLabelCenteredPreview() {
    CardLabel(label = "label", value = "value", centeredText = true)
}

@Preview
@Composable
fun CardLabelStartPreview() {
    CardLabel(label = "label", value = "value", centeredText = false)
}

@Composable
fun CardLabel(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    centeredText: Boolean = true,
    labelTextColor: Color = MainColor,
    valueTextColor: Color = MainColor,
    onClickListener: (() -> Unit)? = null,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            shape = RoundedCornerShape(dimen10),
            modifier = Modifier.clickable { onClickListener?.invoke() },
            elevation = CardDefaults.cardElevation(dimen8),
            colors = CardColorsDefaults
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = if (centeredText) Alignment.CenterHorizontally else Alignment.Start
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = dimen16)
                        .padding(top = dimen16)
                ) {
                    TextMain(
                        text = label,
                        color = labelTextColor
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(horizontal = dimen16)
                        .padding(bottom = dimen16, top = dimen4)
                ) {
                    TextMain(
                        text = value,
                        color = valueTextColor,
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        }
    }
}