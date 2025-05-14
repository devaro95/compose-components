package com.extensions

import com.constants.LINE_JUMP_STRING
import com.vro.constants.EMPTY_STRING

fun String.removeLineJump() = replace(LINE_JUMP_STRING, EMPTY_STRING)