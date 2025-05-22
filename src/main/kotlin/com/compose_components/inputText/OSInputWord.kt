package com.compose_components.inputText

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose_components.R
import com.compose_components.text.TextMain
import com.extensions.removeLineJump
import com.style.HintColorV2
import com.style.RedColor
import com.style.SecondaryColorV2
import com.style.TextPrimary
import com.style.cornersRadius
import com.style.dimen8
import com.vro.constants.INT_ONE
import com.vro.constants.INT_ZERO

@Composable
fun OSInputWord(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isError: Boolean = false,
    errorText: String? = null,
    maxLength: Int = INT_ZERO,
    label: String
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(cornersRadius))
            .background(White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            TextMain(
                text = label,
                fontSize = 14.sp,
                color = SecondaryColorV2,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            BasicTextField(
                value = value,
                onValueChange = {
                    val processed = it.removeLineJump()
                    if (processed.length < maxLength) {
                        onValueChange(it)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 25.dp),
                textStyle = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black
                ),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .padding(0.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }
                        innerTextField()
                    }
                }
            )

            if (isError) {

                Spacer(modifier = Modifier.height(4.dp))

                InputTextFooter(
                    errorText = errorText
                )
            }
        }
    }
}

@Composable
private fun InputTextFooter(
    errorText: String?
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = dimen8),
        verticalAlignment = Alignment.Top
    ) {
        if (errorText != null) {
            TextMain(
                modifier = Modifier.padding(end = dimen8),
                text = errorText,
                color = RedColor,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Preview
@Composable
private fun OSInputWordPreview() {
    Column(modifier = Modifier.background(White)) {
        OSInputWord(
            value = "This is the value",
            label = "Palabra 1",
            placeholder = "Palabra 1",
            onValueChange = {}
        )
    }
}