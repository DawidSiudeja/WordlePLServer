package com.example.di


import com.example.repository.WordRepository
import com.example.repository.WordRepositoryImpl
import org.koin.dsl.module

val koinModule = module {
    single<WordRepository> {
        WordRepositoryImpl()
    }
}