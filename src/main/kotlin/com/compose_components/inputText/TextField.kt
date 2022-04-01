package com.compose_components.inputText

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose_components.R
import com.style.dimen20
import com.style.dimen8

@Composable
fun InputTextPrimary(
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
    var textFieldValueState by remember { mutableStateOf(value) }
    val focusManager = LocalFocusManager.current
    OutlinedTextField(
        enabled = enabled,
        readOnly = readOnly,
        value = textFieldValueState,
        onValueChange = {
            maxLength?.let { maxLength ->
                if (it.length <= maxLength) {
                    textFieldValueState = it
                    if (value != it) {
                        onValueChange(it)
                    }
                }
            } ?: run {
                textFieldValueState = it
                if (value != it) {
                    onValueChange(it)
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
fun InputTextPassword(
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
    InputTextPrimary(
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