package com.example.application_eval_diiage_p2_voyard_romain.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application_eval_diiage_p2_voyard_romain.domain.mocke.getMockedPokemon
import com.example.application_eval_diiage_p2_voyard_romain.domain.models.Pokemon
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ListPokeViewmodels : ViewModel() {
    private val _pokemonList = MutableStateFlow<List<Pokemon>>(emptyList()) // État de la liste
    val pokemonList: StateFlow<List<Pokemon>> = _pokemonList                // Exposition de l'état

    init {
        fetchPokemonList()
    }

    private fun fetchPokemonList() {
        viewModelScope.launch {
            try {
                // Remplacez l'appel au repository par l'appel du mock
                val response = getMockedPokemon()
                _pokemonList.value = response // Mettez à jour l'état avec les données mockées
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}