package com.compose_components.swipeRefresh

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun MainSwipeRefresh(
    state: Boolean,
    onRefresh: () -> Unit,
    modifier: Modifier = Modifier,
    swipeEnabled: Boolean = true,
    refreshTriggerDistance: Dp = 80.dp,
    indicatorAlignment: Alignment = Alignment.TopCenter,
    indicatorPadding: PaddingValues = PaddingValues(0.dp),
    clipIndicatorToPadding: Boolean = true,
    content: @Composable () -> Unit,
) {
    SwipeRefresh(
        state = rememberSwipeRefreshState(state),
        onRefresh = onRefresh,
        modifier = modifier,
        swipeEnabled = swipeEnabled,
        refreshTriggerDistance = refreshTriggerDistance,
        indicatorAlignment = indicatorAlignment,
        indicatorPadding = indicatorPadding,
        indicator = { indicatorState, indicatorTrigger ->
            SwipeRefreshIndicator(
                state = indicatorState,
                refreshTriggerDistance = indicatorTrigger,
                scale = true,
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = MaterialTheme.colors.primaryVariant
            )
        },
        clipIndicatorToPadding = clipIndicatorToPadding,
        content = content
    )
}