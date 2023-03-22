package com.example.instagramclone.screens.profile

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramclone.data.*


@Composable
fun ProfileScreen() {
    ProfileSection()
}

@Preview
@Composable
fun ProfileSection() {
    var user = User(
        username = "_cunit_",
        profileImageUrl = "https://via.placeholder.com/200",
        followers = 47,
        following = 45,
        name = "Tran Anh Thuan",
        description = "Mô tả bản thân",
        stories = listOf(
            Storye(image = "https://via.placeholder.com/200", text = "Story 1"),
            Storye(image = "https://via.placeholder.com/200", text = "Story 2"),
            Storye(image = "https://via.placeholder.com/200", text = "Story 3"),
            Storye(image = "https://via.placeholder.com/200", text = "Story 4"),
            Storye(image = "https://via.placeholder.com/200", text = "Story 5"),
            Storye(image = "https://via.placeholder.com/200", text = "Story 6"),
            Storye(image = "https://via.placeholder.com/200", text = "Story 7"),
            Storye(image = "https://via.placeholder.com/200", text = "Story 8")
        ),
        posts = listOf(
            "https://via.placeholder.com/1000",
            "https://via.placeholder.com/1000",
            "https://via.placeholder.com/1000",
            "https://via.placeholder.com/1000",
            "https://via.placeholder.com/1000",
            "https://via.placeholder.com/1000",
            "https://via.placeholder.com/1000",
            "https://via.placeholder.com/1000",

        )
    )
    Column {
        ProfileHeader(
            backClick = { /*TODO*/ },
            notificationClick = { /*TODO*/ },
            optionClick = { /*TODO*/ },
            username = user.username)
        ProfileInfomation(
            imageUrl = user.profileImageUrl,
            posts = user.posts.size,
            followers = user.followers,
            following = user.following
        )
        ProfileDescription(
            name = user.name,
            description = user.description,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
        )
        ProfileAction(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        ProfileStory(
            stories = user.stories,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
        )
        ProfilePost(images = user.posts, modifier = Modifier.padding(16.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
