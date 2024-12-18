package com.example.application_eval_diiage_p2_voyard_romain.ui.screens

import androidx.lifecycle.ViewModel
import com.example.application_eval_diiage_p2_voyard_romain.domain.mocke.getMockedPokemon
import com.example.application_eval_diiage_p2_voyard_romain.domain.models.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailPokeViewmodels : ViewModel() {

    private val _pokemonDetail = MutableStateFlow<Pokemon?>(null) // État du Pokémon sélectionné
    val pokemonDetail: StateFlow<Pokemon?> = _pokemonDetail        // Exposition de l'état

    fun fetchPokemonDetail(pokemonId: Int) {
        // Récupérer le Pokémon correspondant dans les données mockées
        val pokemon = getMockedPokemon().find { it.id == pokemonId }
        _pokemonDetail.value = pokemon
    }
}