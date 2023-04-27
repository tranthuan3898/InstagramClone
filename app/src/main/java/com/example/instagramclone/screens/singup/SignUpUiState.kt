package com.example.instagramclone.screens.singup

data class SignUpUiState(
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val error: String = ""
)