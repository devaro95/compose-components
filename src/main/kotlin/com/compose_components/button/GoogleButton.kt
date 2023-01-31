package com.compose_components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose_components.R
import com.constants.EMPTY

@Composable
@Preview
fun GoogleButtonPreview() = GoogleButton(onClickListener = {})

@Composable
fun GoogleButton(
    modifier: Modifier = Modifier,
    onClickListener: (() -> Unit),
    contentDescription: String = EMPTY,
    backgroundColor: Color = MaterialTheme.colors.primary
) {
    Button(
        onClick = onClickListener,
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        )
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.ic_google),
            contentDescription = contentDescription
        )
    }
}