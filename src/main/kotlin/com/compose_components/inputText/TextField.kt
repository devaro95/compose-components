package com.compose_components.inputText

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose_components.R
import com.style.cornersRadius
import com.style.dimen1
import com.style.dimen14
import com.style.dimen16
import com.style.dimen20
import com.style.dimen8
import com.style.textSize14

@Composable
fun InputTextOutlined(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: String,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    errorText: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    inputType: KeyboardType = KeyboardType.Text,
    singleLine: Boolean = false,
    maxLines: Int = Int.MAX_VALUE,
    maxLength: Int? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    acceptButtonAction: ImeAction? = null,
) {
    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = value)) }
    val textFieldValue = textFieldValueState.copy(text = value)
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        enabled = enabled,
        readOnly = readOnly,
        value = textFieldValue,
        onValueChange = {
            maxLength?.let { maxLength ->
                if (it.text.length <= maxLength) {
                    textFieldValueState = it
                    if (value != it.text) {
                        onValueChange(it.text)
                    }
                }
            } ?: run {
                textFieldValueState = it
                if (value != it.text) {
                    onValueChange(it.text)
                }
            }
        },
        modifier = modifier,
        singleLine = singleLine,
        textStyle = textStyle,
        label = {
            Text(
                color = MaterialTheme.colors.primary,
                text = label,
                fontSize = 10.sp
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
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = MaterialTheme.colors.primary
        )
    )
    if (isError && errorText != null) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = dimen8),
            text = errorText,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
fun InputTextOutlinedPassword(
    value: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
    label: String,
    isError: Boolean = false,
    errorText: String? = null,
    maxLines: Int = Int.MAX_VALUE,
    maxLength: Int? = null,
) {
    var passwordVisible by remember { mutableStateOf(false) }
    InputTextOutlined(
        modifier = modifier,
        value = value,
        onValueChange = { onTextChange(it) },
        textStyle = textStyle,
        visualTransformation =
        if (passwordVisible) VisualTransformation.None
        else PasswordVisualTransformation(),
        label = label,
        inputType = KeyboardType.Password,
        isError = isError,
        errorText = errorText,
        singleLine = true,
        trailingIcon = {
            Icon(
                modifier = Modifier
                    .size(dimen20)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }) { passwordVisible = !passwordVisible },
                painter = painterResource(
                    if (passwordVisible) R.drawable.ic_password
                    else R.drawable.ic_password_hidden
                ),
                tint = MaterialTheme.colors.primary,
                contentDescription = null
            )
        },
        maxLength = maxLength,
        maxLines = maxLines,
    )
}

@Preview
@Composable
fun Previeww() {
    InputText(onTextChange = {}, value = "value", label = "label")
}

@Composable
fun InputText(
    backgroundColor: Color = Color.White,
    textColor: Color = MaterialTheme.colors.primary,
    labelColor: Color = MaterialTheme.colors.secondary,
    startIcon: Int = R.drawable.ic_password,
    startIconTint: Color = MaterialTheme.colors.secondary,
    radius: Dp = cornersRadius,
    value: String,
    label: String,
    onTextChange: (String) -> Unit,
) {
    Box(contentAlignment = Alignment.BottomCenter) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = { onTextChange(it) },
            shape = RoundedCornerShape(radius),
            colors = TextFieldDefaults.textFieldColors(
                textColor = textColor,
                backgroundColor = backgroundColor,
                focusedLabelColor = labelColor,
                unfocusedLabelColor = labelColor
            ),
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(dimen16),
                    painter = painterResource(id = startIcon),
                    contentDescription = null,
                    tint = startIconTint
                )
            },
            label = { Text(text = label, fontSize = textSize14, fontWeight = FontWeight.Normal) }
        )
        Divider(Modifier
            .padding(
                top = dimen8,
                start = 52.dp,
                end = dimen16,
                bottom = dimen14
            )
            .height(dimen1),
            color = MaterialTheme.colors.secondary)
    }
}