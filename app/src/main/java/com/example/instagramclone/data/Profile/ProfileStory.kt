package com.example.instagramclone.data

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProfileStory(
    stories: List<Storye>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
    ) {
        items(stories) {
            StoryItem(it)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
private fun StoryItem(
    story: Storye,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = story.image,
            contentDescription = "story image",
            modifier = Modifier.clip(CircleShape)
        )
        Text(text = story.text)
    }
}

@Preview
@Composable
fun ProfileStoryPreview() {
    ProfileStory(emptyList())
}