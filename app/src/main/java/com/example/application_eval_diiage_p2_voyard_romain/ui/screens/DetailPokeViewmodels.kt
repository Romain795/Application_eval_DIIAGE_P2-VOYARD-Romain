package com.example.application_eval_diiage_p2_voyard_romain.ui.screens

import androidx.lifecycle.ViewModel
import com.example.application_eval_diiage_p2_voyard_romain.domain.mocke.getMockedPokemon
import com.example.application_eval_diiage_p2_voyard_romain.domain.mocke.getMockedPokemonDetails
import com.example.application_eval_diiage_p2_voyard_romain.domain.models.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailPokeViewmodels : ViewModel() {

    private val _pokemonDetail = MutableStateFlow<Pokemon?>(null) // État du Pokémon sélectionné
    val pokemonDetail: StateFlow<Pokemon?> = _pokemonDetail        // Exposition de l'état

    fun fetchPokemonDetail() {
        // Récupérer le Pokémon Bulbizarre depuis les données mockées
        val pokemon = getMockedPokemonDetails() // Pas de paramètre car il n'y a qu'un seul Pokémon
        _pokemonDetail.value = pokemon
    }
}
