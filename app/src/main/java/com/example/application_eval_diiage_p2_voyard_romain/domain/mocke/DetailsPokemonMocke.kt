package com.example.application_eval_diiage_p2_voyard_romain.domain.mocke

import com.example.application_eval_diiage_p2_voyard_romain.domain.models.Pokemon
import com.example.application_eval_diiage_p2_voyard_romain.domain.models.Type
import com.example.application_eval_diiage_p2_voyard_romain.domain.models.Ability

/**
 * Cela permet de simuler un appel au detail d'un pokemon de la PokeAPI avec un seul Pokémon : Bulbizarre
 */
fun getMockedPokemonDetails(): Pokemon {
    return Pokemon(
        id = 1,
        name = "Bulbizarre",
        types = listOf(Type(name = "Plante"), Type(name = "Poison")),
        abilities = listOf(
            Ability(name = "Engrais"),
            Ability(name = "Chlorophylle")
        ),
        image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
        url = "https://pokeapi.co/api/v2/pokemon/1",
        created = "1996-02-27"
    )
}