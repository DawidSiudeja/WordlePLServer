package com.example.repository

import com.example.modules.ApiResponse
import com.example.modules.Word


class WordRepositoryImpl: WordRepository {

    override val words = listOf(
        Word(
            id = 0,
            name = "album",
            letters = 5
        ),
        Word(
            id = 1,
            name = "towar",
            letters = 5
        ),
        Word(
            id = 2,
            name = "zimno",
            letters = 5
        ),
        Word(
            id = 3,
            name = "letni",
            letters = 5
        ),
        Word(
            id = 4,
            name = "aneks",
            letters = 5
        )
    )

    override suspend fun getAllWords(): ApiResponse {
        return ApiResponse(
            success = true,
            message = "ok",
            words = words
        )
    }

    override suspend fun searchWord(query: String?): ApiResponse {
        return if(findWord(query).isNotEmpty()) {
            ApiResponse(
                success = true,
                message = "ok",
                words = findWord(query)
            )
        } else {
            ApiResponse(
                success = true,
                message = "Word is not founded",
                words = emptyList()
            )
        }
    }

    override suspend fun getRandomWord(letters: String?): ApiResponse {
        return if(randomWord(letters).isNotEmpty()) {
            ApiResponse(
                success = true,
                message = "ok",
                words = randomWord(letters)
            )
        } else {
            ApiResponse(
                success = true,
                message = "Invalid numbers of letters",
                words = emptyList()
            )
        }

    }

    private fun randomWord(letters: String?): List<Word> {
        val randomWord = mutableListOf<Word>()
        return if(!letters.isNullOrEmpty()) {

            val lettersAsInt = letters.toIntOrNull()
            val matchingWords = words.filter { it.letters == lettersAsInt }

            if(matchingWords.isNotEmpty()) {
                val temporaryRandomWord = matchingWords.random()
                randomWord.add(temporaryRandomWord)
            }

            randomWord
        } else {
            emptyList()
        }
    }

    /*

    private fun randomWord(letters: String?): List<Word> {
    val randomWord = mutableListOf<Word>()
    if (!letters.isNullOrEmpty()) {
        val lettersAsInt = letters.toIntOrNull()
        if (lettersAsInt != null) {
            val matchingWords = words.filter { it.letters == lettersAsInt }
            if (matchingWords.isNotEmpty()) {
                val temporaryRandomWord = matchingWords.random()
                randomWord.add(temporaryRandomWord)
            }
        }
    }
    return randomWord
}
     */


    private fun findWord(query: String?): List<Word> {

        val foundedWord = mutableListOf<Word>()

        return if(!query.isNullOrEmpty()) {
            words.forEach { word ->
                if(word.name.lowercase() == query.lowercase()) {
                    foundedWord.add(word)
                }
            }
            foundedWord
        } else {
            emptyList()
        }

    }

}