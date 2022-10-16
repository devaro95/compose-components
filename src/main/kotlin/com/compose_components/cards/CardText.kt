package com.compose_components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.style.cornersRadius
import com.style.dimen1
import com.style.dimen16
import com.style.dimen8

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
        backgroundColor = backgroundColor,
        elevation = elevation
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
        backgroundColor = if (isActive) MaterialTheme.colors.primary else MaterialTheme.colors.primaryVariant,
        border = if (isActive) null else BorderStroke(dimen1, MaterialTheme.colors.primary)
    )
    {
        Text(
            modifier = Modifier.padding(dimen8),
            text = text,
            color = if (isActive) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.primary
        )
    }
}