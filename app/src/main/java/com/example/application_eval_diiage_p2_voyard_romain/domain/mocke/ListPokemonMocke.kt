package com.example.application_eval_diiage_p2_voyard_romain.domain.mocke

import com.example.application_eval_diiage_p2_voyard_romain.domain.models.Pokemon
import com.example.application_eval_diiage_p2_voyard_romain.domain.models.Type
import com.example.application_eval_diiage_p2_voyard_romain.domain.models.Ability

/**
 * Cela permer de simuler un appelle à la PokeAPI
 */
fun getMockedPokemon(): List<Pokemon> {
    return listOf(
        Pokemon(
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
        ),
        Pokemon(
            id = 2,
            name = "Herbizarre", // Nom en français
            types = listOf(Type(name = "Plante"), Type(name = "Poison")),
            abilities = listOf(
                Ability(name = "Engrais"),
                Ability(name = "Chlorophylle")
            ),
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png",
            url = "https://pokeapi.co/api/v2/pokemon/2",
            created = "1996-02-27"
        ),
        Pokemon(
            id = 3,
            name = "Florizarre", // Nom en français
            types = listOf(Type(name = "Plante"), Type(name = "Poison")),
            abilities = listOf(
                Ability(name = "Engrais"),
                Ability(name = "Chlorophylle")
            ),
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png",
            url = "https://pokeapi.co/api/v2/pokemon/3",
            created = "1996-02-27"
        ),
        Pokemon(
            id = 4,
            name = "Salamèche", // Nom en français
            types = listOf(Type(name = "Feu")),
            abilities = listOf(
                Ability(name = "Brasier"),
                Ability(name = "Solar Power")
            ),
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
            url = "https://pokeapi.co/api/v2/pokemon/4",
            created = "1996-02-27"
        ),
        Pokemon(
            id = 5,
            name = "Reptincel", // Nom en français
            types = listOf(Type(name = "Feu")),
            abilities = listOf(
                Ability(name = "Brasier"),
                Ability(name = "Solar Power")
            ),
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png",
            url = "https://pokeapi.co/api/v2/pokemon/5",
            created = "1996-02-27"
        ),
        Pokemon(
            id = 6,
            name = "Dracaufeu", // Nom en français
            types = listOf(Type(name = "Feu"), Type(name = "Vol")),
            abilities = listOf(
                Ability(name = "Brasier"),
                Ability(name = "Solar Power")
            ),
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png",
            url = "https://pokeapi.co/api/v2/pokemon/6",
            created = "1996-02-27"
        ),
        Pokemon(
            id = 7,
            name = "Carapuce", // Nom en français
            types = listOf(Type(name = "Eau")),
            abilities = listOf(
                Ability(name = "Torrent"),
                Ability(name = "Pluie Fine")
            ),
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
            url = "https://pokeapi.co/api/v2/pokemon/7",
            created = "1996-02-27"
        ),
        Pokemon(
            id = 8,
            name = "Carabaffe", // Nom en français
            types = listOf(Type(name = "Eau")),
            abilities = listOf(
                Ability(name = "Torrent"),
                Ability(name = "Pluie Fine")
            ),
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/8.png",
            url = "https://pokeapi.co/api/v2/pokemon/8",
            created = "1996-02-27"
        ),
        Pokemon(
            id = 9,
            name = "Tortank", // Nom en français
            types = listOf(Type(name = "Eau")),
            abilities = listOf(
                Ability(name = "Torrent"),
                Ability(name = "Pluie Fine")
            ),
            image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/9.png",
            url = "https://pokeapi.co/api/v2/pokemon/9",
            created = "1996-02-27"
        )
    )
}