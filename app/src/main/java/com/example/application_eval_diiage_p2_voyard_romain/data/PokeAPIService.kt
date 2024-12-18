package com.example.application_eval_diiage_p2_voyard_romain.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// Modèle de réponse des Pokémon (simplifié)
data class PokemonResponse(
    val results: List<Pokemon> // Liste de Pokémon
)

data class Pokemon(
    val name: String,          // Nom du Pokémon
    val url: String            // URL avec les détails
)

data class PokemonDetailResponse(
    val id: Int, // ID du Pokémon
    val name: String, // Nom du Pokémon
    val height: Int, // Taille du Pokémon
    val weight: Int, // Poids du Pokémon
    val types: List<PokemonTypeSlot>, // Types du Pokémon
    val sprites: PokemonSprites // Images du Pokémon
)

data class PokemonTypeSlot(
    val slot: Int, // Position du type (ex : 1er ou 2ème type)
    val type: PokemonType
)

data class PokemonType(
    val name: String, // Nom du type (ex : "electric")
    val url: String // URL pour plus de détails sur le type
)

data class PokemonSprites(
    val front_default: String // URL de l'image frontale par défaut
)

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = 100,
        @Query("offset") offset: Int = 0
    ): PokemonResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(@Path("name") name: String): PokemonDetailResponse
}
