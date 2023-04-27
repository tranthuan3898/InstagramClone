package com.example.instagramclone.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp


data class User(
    val username: String,
    val profileImageUrl: String,
    val followers: Int,
    val following: Int,
    val name: String,
    val description: String,
    val stories: List<Storye>,
    val posts: List<String>
)

data class Storye(
    val image: String,
    val text: String
)
