package com.example.instagramclone.data

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.instagramclone.screens.profile.ProfileScreen

@Composable
fun ProfileInfomation(
    imageUrl: String,
    posts: Int,
    followers: Int,
    following: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "profile image",
            modifier = Modifier.clip(CircleShape)
        )
        ProfileInfomationItem(posts, type = "Bài viết")
        ProfileInfomationItem(followers, type = "Người theo dõi")
        ProfileInfomationItem(following, type = "Đang theo dõi")
    }

}

@Composable
private fun ProfileInfomationItem(
    amount: Int,
    type: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = amount.toString(), fontWeight = FontWeight.Bold)
        Text(text = type)
    }
}

@Preview
@Composable
fun ProfileInfomationPreview() {
    ProfileInfomation(imageUrl = "", posts = 4, followers = 46, following = 43)
}
