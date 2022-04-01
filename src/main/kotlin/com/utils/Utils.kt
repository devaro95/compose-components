package com.utils

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.verticalScroll() = composed { verticalScroll(rememberScrollState()) }
