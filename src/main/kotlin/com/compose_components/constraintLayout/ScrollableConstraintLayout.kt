package com.compose_components.constraintLayout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope

@Composable
fun ScrollableConstraintLayout(
    modifier: Modifier = Modifier,
    content: @Composable ConstraintLayoutScope.() -> Unit,
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        content = content
    )
}