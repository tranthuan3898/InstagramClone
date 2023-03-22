package com.example.instagramclone.data

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items //note
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProfilePost(
    images: List<String>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(modifier = modifier, columns = GridCells.Fixed(3)){
        items(images) {
            PostItem(imageUrl = it, modifier = Modifier.padding(1.dp))
        }
    }
}

@Composable
private fun PostItem(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        AsyncImage(model = imageUrl, contentDescription = "user post")
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePostPreview() {
    ProfilePost(emptyList())
}