package com.compose_components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.style.*

@Preview
@Composable
fun CardTextPreview() {
    CardText(text = "label", textColor = Color.Black, backgroundColor = Color.White)
}

@Composable
fun CardText(
    text: String,
    textColor: Color = Color.Black,
    backgroundColor: Color = Color.White,
    elevation: Dp = dimen8,
    contentPadding: Dp = dimen16,
    cornerRadius: Dp = cornersRadius,
) {
    Card(
        shape = RoundedCornerShape(cornerRadius),
        modifier = Modifier
            .padding(end = dimen8)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.cardElevation(elevation)
    ) {
        Column(modifier = Modifier.padding(contentPadding)) {
            Text(
                text = text,
                color = textColor
            )
        }
    }
}

@Composable
fun CardText(text: String, isActive: Boolean) {
    Card(
        modifier = Modifier.padding(end = dimen8),
        colors = CardDefaults.cardColors(
            containerColor = if (isActive) MainColor else TextSecondary,
        ),
        border = if (isActive) null else BorderStroke(dimen1, MainColor)
    )
    {
        Text(
            modifier = Modifier.padding(dimen8),
            text = text,
            color = if (isActive) TextSecondary else TextPrimary
        )
    }
}