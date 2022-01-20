package com.compose_components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.compose_components.text.TextMain
import com.style.dimen10
import com.style.dimen16
import com.style.dimen4
import com.style.dimen8

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
    labelTextColor: Color = MaterialTheme.colors.primary,
    valueTextColor: Color = MaterialTheme.colors.primary,
    onClickListener: (() -> Unit)? = null,
) {
    Card(
        shape = RoundedCornerShape(dimen10),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClickListener?.invoke() },
        elevation = dimen8) {
        Column(horizontalAlignment = if (centeredText) Alignment.CenterHorizontally else Alignment.Start) {
            Row(modifier = Modifier
                .padding(horizontal = dimen16)
                .padding(top = dimen16)) {
                TextMain(
                    text = label,
                    color = labelTextColor)
            }
            Row(modifier = Modifier
                .padding(horizontal = dimen16)
                .padding(bottom = dimen16, top = dimen4)) {
                TextMain(text = value,
                    color = valueTextColor,
                    style = MaterialTheme.typography.h2)
            }
        }
    }
}