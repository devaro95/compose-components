package com.compose_components.inputText

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose_components.R
import com.compose_components.text.TextMain
import com.constants.LINE_JUMP_CHAR
import com.extensions.removeLineJump
import com.style.*
import com.vro.constants.INT_ZERO
import com.vro.constants.SPACE

@Composable
fun InputTextPrimary(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = TextStyle(
        fontFamily = FontFamily(Font(R.font.open_sans_regular)),
        fontSize = 16.sp
    ),
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    errorText: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    inputType: KeyboardType = KeyboardType.Text,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    maxLength: Int = INT_ZERO,
    showCounter: Boolean = false,
    minLength: Int = INT_ZERO,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    acceptButtonAction: ImeAction? = null,
    disableLineJump: Boolean = false,
) {
    val focusManager = LocalFocusManager.current
    val isError = isError(isError, errorText) || minLengthError(value, minLength)
    Column {
        OutlinedTextField(
            enabled = enabled,
            readOnly = readOnly,
            value = value,
            onValueChange = {
                val processed = if (disableLineJump) it.removeLineJump() else it
                if ((maxLength == INT_ZERO || processed.length <= maxLength) &&
                    processed.count { char -> char == LINE_JUMP_CHAR } < maxLines
                ) {
                    onValueChange(processed)
                }
            },
            modifier = modifier.fillMaxWidth(),
            singleLine = singleLine,
            textStyle = textStyle,
            label = {
                TextMain(
                    color = TextPrimary,
                    text = label,
                    fontSize = 14.sp
                )
            },
            placeholder = placeholder,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            isError = isError,
            visualTransformation = visualTransformation,
            keyboardOptions = KeyboardOptions(
                keyboardType = inputType,
                imeAction = acceptButtonAction ?: ImeAction.Next
            ),
            maxLines = maxLines,
            interactionSource = interactionSource,
            shape = RoundedCornerShape(10.dp),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            colors = inputColorsDefault
        )
        InputTextFooter(
            value = value,
            errorText = errorText,
            isError = isError,
            minLength = minLength,
            maxLength = maxLength,
            showCounter = maxLength != INT_ZERO || showCounter
        )
    }
}

@Composable
private fun InputTextFooter(
    value: String,
    errorText: String?,
    isError: Boolean,
    minLength: Int,
    maxLength: Int,
    showCounter: Boolean,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimen8)
            .padding(horizontal = dimen8),
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            ErrorMessage(
                value = value,
                isError = isError,
                errorText = errorText,
                minLength = minLength
            )
        }
        Column {
            if (showCounter) {
                CharactersText(
                    string = value,
                    maxLength = maxLength
                )
            }
        }
    }
}

@Composable
fun CharactersText(
    string: String,
    maxLength: Int = INT_ZERO,
) {
    Row(horizontalArrangement = Arrangement.End) {
        TextMain(text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = MainColor)) {
                append(string.length.toString())
            }
            if (maxLength != INT_ZERO) {
                append(SPACE)
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(stringResource(id = R.string.character_counter_separator, maxLength))
                }
            }
        })
    }
}

@Composable
private fun ErrorMessage(
    value: String,
    isError: Boolean,
    errorText: String?,
    minLength: Int = INT_ZERO,
) {
    when {
        isError(isError, errorText) -> {
            TextMain(
                modifier = Modifier.padding(end = dimen8),
                text = errorText.orEmpty(),
                color = RedColor,
                textAlign = TextAlign.Start
            )
        }

        minLengthError(value, minLength) -> {
            TextMain(
                modifier = Modifier.padding(end = dimen8),
                text = stringResource(R.string.min_length_error, minLength),
                color = RedColor,
                textAlign = TextAlign.Start
            )
        }
    }
}

private fun isError(
    isError: Boolean,
    errorText: String?,
) = isError && errorText != null

private fun minLengthError(
    value: String,
    minLength: Int = INT_ZERO,
) = minLength != INT_ZERO && value.length < minLength && value.length > INT_ZERO


@Preview
@Composable
private fun InputTextPrimaryPreview() {
    Column(modifier = Modifier.background(White)) {
        InputTextPrimary(
            value = "This is the value",
            onValueChange = {},
            maxLength = 100,
            minLength = 5,
            label = "Label"
        )
    }
}