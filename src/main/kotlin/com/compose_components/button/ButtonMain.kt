package com.compose_components.button

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.style.cornersRadius
import com.style.textSize14

@Preview
@Composable
fun ButtonMainPreview() {
    ButtonMain(text = "Button", onClick = { })
}

@Composable
fun ButtonMain(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = MaterialTheme.colors.secondaryVariant,
    fontSize: TextUnit = textSize14,
    borderCorner: RoundedCornerShape? = null,
    onClick: (() -> Unit),
) {
    Button(
        modifier = modifier.height(40.dp),
        shape = borderCorner ?: RoundedCornerShape(cornersRadius),
        onClick = onClick,
    ) {
        Text(text = text, color = textColor, fontSize = fontSize, fontWeight = FontWeight.Bold)
    }
}