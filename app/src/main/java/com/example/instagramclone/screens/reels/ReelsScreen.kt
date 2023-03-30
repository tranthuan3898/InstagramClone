package com.example.instagramclone.screens.reels

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter

@ExperimentalFoundationApi
@Composable
fun ReelsScreen() {
//    val pagerState = rememberPagerState(pageCount = ReelsList.size)

    VerticalPager(
        pageCount = ReelsList.size,
        contentPadding = PaddingValues(top = 64.dp, bottom = 64.dp),
    ) { index ->
        // Our page content
        AsyncImage(
            model = ReelsList[index],
            contentDescription = null,
            modifier = Modifier.fillMaxWidth()
        )
    }
}



val ReelsList = listOf(
    "https://picsum.photos/200/300?random=1",
    "https://picsum.photos/200/300?random=2",
    "https://picsum.photos/200/300?random=3",
    "https://picsum.photos/200/300?random=4",
    "https://picsum.photos/200/300?random=5",
    "https://picsum.photos/200/300?random=6",
    "https://picsum.photos/200/300?random=7",
    "https://picsum.photos/200/300?random=8",
    "https://picsum.photos/200/300?random=9",
    "https://picsum.photos/200/300?random=10"
)

@Preview
@Composable
@ExperimentalFoundationApi
fun ReelsScreenSection() {
    ReelsScreen()
}