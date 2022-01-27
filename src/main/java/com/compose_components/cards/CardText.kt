package com.compose_components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.style.dimen1
import com.style.dimen8

@Composable
fun CardText(
    text: String,
    textColor: Color,
    backgroundColor: Color,
) {
    Card(
        modifier = Modifier.padding(end = 8.dp),
        backgroundColor = backgroundColor
    ) {
        Text(
            modifier = Modifier.padding(dimen8),
            text = text,
            color = textColor
        )
    }
}

@Composable
fun CardText(text: String, isActive: Boolean) {
    Card(modifier = Modifier.padding(end = dimen8),
        backgroundColor = if (isActive) MaterialTheme.colors.primary else MaterialTheme.colors.primaryVariant,
        border = if (isActive) null else BorderStroke(dimen1, MaterialTheme.colors.primary))
    {
        Text(modifier = Modifier.padding(dimen8),
            text = text,
            color = if (isActive) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.primary
        )
    }
}