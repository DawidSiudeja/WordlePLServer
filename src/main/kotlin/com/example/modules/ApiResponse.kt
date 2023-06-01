package com.example.modules

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val words: List<Word> = emptyList(),
)