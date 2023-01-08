package com.extensions

import com.compose_components.inputText.EMPTY
import com.compose_components.inputText.LINE_JUMP_STRING

fun String.removeLineJump() = replace(LINE_JUMP_STRING, EMPTY)