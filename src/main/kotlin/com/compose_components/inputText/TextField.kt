package com.compose_components.inputText

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
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
import androidx.compose.ui.res.colorResource
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
import com.style.*

@Preview
@Composable
fun PreviewInputTextOutlined() {
    InputTextOutlined(
        value = "value",
        label = "label",
        onValueChange = {}
    )
}

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
                fontSize = textSize10
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

@Preview
@Composable
fun PreviewInputTextOutlinedPassword() {
    InputTextOutlinedPassword(
        onTextChange = {},
        value = "value",
        label = "label",
    )
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
                        interactionSource = remember { MutableInteractionSource() }) {
                        passwordVisible = !passwordVisible
                    },
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
fun PreviewInputText() {
    InputText(onValueChange = {},
        value = "",
        label = "label",
        startIcon = { Icon(imageVector = Icons.Filled.Search, contentDescription = null) },
        endIcon = {
            Icon(painter = painterResource(id = R.drawable.ic_single_person),
                contentDescription = null,
                modifier = Modifier.size(dimen20)
            )
        }
    )
}

@Composable
fun InputText(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    textColor: Color = MaterialTheme.colors.primary,
    labelColor: Color = MaterialTheme.colors.secondary,
    startIcon: @Composable (() -> Unit)? = null,
    endIcon: @Composable (() -> Unit)? = null,
    placeholder: String = "",
    radius: Dp = cornersRadius,
    value: String = "",
    label: String? = null,
    isUnderlined: Boolean = true,
    onValueChange: ((String) -> Unit),
    maxLength: Int? = null,
) {
    var textFieldValueState by remember { mutableStateOf(TextFieldValue(text = value)) }
    val textFieldValue = textFieldValueState.copy(text = value)
    Box(contentAlignment = Alignment.BottomCenter) {
        TextField(
            modifier = modifier,
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
            label = {
                label?.let {
                    Text(
                        text = label,
                        fontSize = textSize10,
                        fontWeight = FontWeight.Normal,
                        color = colorResource(id = R.color.grey)
                    )
                }
            },
            shape = RoundedCornerShape(radius),
            colors = TextFieldDefaults.textFieldColors(
                textColor = textColor,
                backgroundColor = backgroundColor,
                focusedLabelColor = labelColor,
                unfocusedLabelColor = labelColor
            ),
            leadingIcon = startIcon,
            trailingIcon = endIcon,
            placeholder = { Text(text = placeholder, color = colorResource(id = R.color.grey)) }
        )
        if (isUnderlined) {
            Divider(Modifier
                .padding(
                    start = dimen52,
                    end = dimen16,
                    bottom = dimen12
                )
                .height(dimen1),
                color = MaterialTheme.colors.secondary)
        }
    }
}