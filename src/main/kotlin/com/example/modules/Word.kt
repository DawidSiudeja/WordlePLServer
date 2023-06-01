package com.example.modules

import kotlinx.serialization.Serializable

@Serializable
data class Word(
    val id: Int,
    val name: String,
    val letters: Int
)