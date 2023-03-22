package com.example.instagramclone.data


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
