package com.example.repository

import com.example.modules.ApiResponse
import com.example.modules.Word

interface WordRepository {

    val words: List<Word>

    suspend fun getAllWords(): ApiResponse
    suspend fun searchWord(query: String?): ApiResponse
    suspend fun getRandomWord(letters: String?): ApiResponse

}