package com.compose_components.text

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.compose_components.R
import com.style.TextPrimary

@Composable
fun TextMain(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = FontFamily(Font(R.font.open_sans_regular)),
    letterSpacing: TextUnit = 0.5.sp,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    color: Color? = null,
) {
    Text(
        text = text,
        color = color ?: TextPrimary,
        modifier = modifier,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
        lineHeight = (fontSize.value + 2).sp
    )
}

@Composable
fun TextMain(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily = FontFamily(Font(R.font.open_sans_regular)),
    letterSpacing: TextUnit = 0.5.sp,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current,
    color: Color? = null,
) {
    Text(
        text = text,
        color = color ?: TextPrimary,
        modifier = modifier,
        fontSize = fontSize,
        fontStyle = fontStyle,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        textAlign = textAlign,
        lineHeight = (fontSize.value + 2).sp,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onTextLayout = onTextLayout,
        style = style
    )
}

@Composable
fun TextMainClickable(
    text: AnnotatedString,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily = FontFamily(Font(R.font.open_sans_regular)),
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign = TextAlign.Unspecified,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow = TextOverflow.Clip,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    color: Color? = null,
    onClick: (() -> Unit)? = null,
    style: TextStyle = LocalTextStyle.current,
) {
    ClickableText(
        text = text,
        style = style.copy(
            color = color ?: TextPrimary,
            fontSize = fontSize,
            fontStyle = fontStyle,
            fontWeight = fontWeight,
            fontFamily = fontFamily,
            letterSpacing = letterSpacing,
            textDecoration = textDecoration,
            textAlign = textAlign,
            lineHeight = lineHeight,
        ),
        modifier = modifier,
        overflow = overflow,
        softWrap = softWrap,
        maxLines = maxLines,
        onClick = { onClick?.invoke() }
    )
}