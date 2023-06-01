package com.example.plugins

import com.example.routes.getAllWords
import com.example.routes.getRandomWord
import com.example.routes.root
import com.example.routes.searchWord
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        root()
        getAllWords()
        searchWord()
        getRandomWord()
    }
}
