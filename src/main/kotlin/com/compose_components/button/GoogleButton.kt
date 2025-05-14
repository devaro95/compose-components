package com.compose_components.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose_components.R
import com.style.MainColor
import com.vro.constants.EMPTY_STRING

@Composable
@Preview
fun GoogleButtonPreview() = GoogleButton(onClickListener = {})

@Composable
fun GoogleButton(
    modifier: Modifier = Modifier,
    onClickListener: (() -> Unit),
    contentDescription: String = EMPTY_STRING,
    backgroundColor: Color = MainColor,
) {
    Button(
        onClick = onClickListener,
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        )
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.ic_google),
            contentDescription = contentDescription
        )
    }
}