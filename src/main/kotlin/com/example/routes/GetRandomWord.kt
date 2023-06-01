package com.example.routes

import org.koin.ktor.ext.inject
import com.example.repository.WordRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getRandomWord() {
    val wordRepository: WordRepository by inject()

    get("words/random") {
        val letters = call.request.queryParameters["letters"]

        val apiResponse = wordRepository.getRandomWord(letters = letters)

        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
}