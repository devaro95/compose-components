package com.compose_components.inputText

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.*
import com.compose_components.R
import com.constants.ZERO
import com.style.TextPrimary
import com.style.dimen20

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
    maxLength: Int = ZERO,
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
                    if (passwordVisible) R.drawable.ic_password_visible
                    else R.drawable.ic_password_hidden
                ),
                tint = TextPrimary,
                contentDescription = null
            )
        },
        maxLength = maxLength,
        maxLines = maxLines,
    )
}
