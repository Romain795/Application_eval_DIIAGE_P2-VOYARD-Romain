package com.example.application_eval_diiage_p2_voyard_romain.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: PokeApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/") // Base URL de la PokeAPI
            .addConverterFactory(GsonConverterFactory.create()) // Conversion JSON -> Kotlin
            .build()
            .create(PokeApiService::class.java)
    }
}