package com.compose_components.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.compose_components.R
import com.compose_components.text.TextMain
import com.style.CardColorsDefaults
import com.style.MainColor
import com.style.cornersRadius
import com.style.dimen10
import com.style.dimen16
import com.style.dimen20
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
    centeredText: Boolean = false,
    labelTextColor: Color = MainColor,
    valueTextColor: Color = MainColor,
    onClickListener: (() -> Unit)? = null,
) {
    Card(
        shape = RoundedCornerShape(cornersRadius),
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClickListener?.invoke() },
        elevation = CardDefaults.cardElevation(dimen8),
        colors = CardColorsDefaults
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(9f),
                horizontalAlignment =
                    if (centeredText) Alignment.CenterHorizontally
                    else Alignment.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextMain(
                        modifier = Modifier
                            .padding(horizontal = dimen16)
                            .padding(top = dimen16)
                            .padding(bottom = dimen8),
                        text = label,
                        color = labelTextColor,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimen16)
                        .padding(bottom = dimen16, top = dimen4)
                ) {
                    TextMain(
                        text = value,
                        color = valueTextColor,
                    )
                }
            }
            Icon(
                modifier = Modifier
                    .size(dimen20)
                    .weight(1f),
                painter = painterResource(id = R.drawable.ic_arrow_right),
                contentDescription = null,
                tint = MainColor
            )
        }
    }
}