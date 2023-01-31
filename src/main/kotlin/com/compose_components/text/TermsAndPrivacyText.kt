package com.compose_components.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import com.compose_components.R

@Composable
@Preview
fun TermsAndPrivacyTextPreview() = TermsAndPrivacyText({})

@Composable
fun TermsAndPrivacyText(
    onClickListener: () -> Unit,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    TextMainClickable(
        modifier = modifier,
        textAlign = textAlign,
        text = buildAnnotatedString {
            append(stringResource(id = R.string.terms_and_privacy_text))
            append(SPACE)
            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                append(stringResource(id = R.string.terms_and_privacy))
            }
            append(SPACE)
            append(stringResource(id = R.string.terms_and_privacy_end))
        },
        onClick = onClickListener
    )
}