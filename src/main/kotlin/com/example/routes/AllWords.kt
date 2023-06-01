package com.example.routes

import org.koin.ktor.ext.inject
import com.example.repository.WordRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getAllWords() {

    val wordRepository: WordRepository by inject()

    get("/words/all") {

        val apiResponse = wordRepository.getAllWords()

        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
}