package com.compose_components.horizontalPager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import com.constants.ZERO
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@ExperimentalPagerApi
@Composable
fun createPagerState(pages: Int, initial: Int = ZERO, infinite: Boolean = false, initialOffScreen: Int = 2): PagerState {
    return rememberPagerState(
        pageCount = pages,
        initialOffscreenLimit = initialOffScreen,
        infiniteLoop = infinite,
        initialPage = initial,
    )
}

@ExperimentalPagerApi
@Composable
fun rememberPagerState(
    pageCount: Int,
    initialPage: Int = ZERO,
    initialPageOffset: Float = 0f,
    initialOffscreenLimit: Int = 1,
    infiniteLoop: Boolean = false,
) = rememberSaveable(saver = PagerState.Saver) {
    PagerState(
        pageCount = pageCount,
        currentPage = initialPage,
        currentPageOffset = initialPageOffset,
        offscreenLimit = initialOffscreenLimit,
        infiniteLoop = infiniteLoop
    )
}