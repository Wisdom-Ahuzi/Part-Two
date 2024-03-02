package com.example.parttwo.Presentation.Signup

data class SignupState(
    val isLoading: Boolean = false,
    val isSuccess: String? = "",
    val isError: String? = ""
)
