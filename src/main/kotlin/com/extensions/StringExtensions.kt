package com.extensions

import com.constants.EMPTY
import com.constants.LINE_JUMP_STRING

fun String.removeLineJump() = replace(LINE_JUMP_STRING, EMPTY)