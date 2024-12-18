package com.example.application_eval_diiage_p2_voyard_romain.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application_eval_diiage_p2_voyard_romain.data.PokemonDetailResponse
import com.example.application_eval_diiage_p2_voyard_romain.data.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailPokeViewmodels : ViewModel() {
    private val _pokemonDetails = MutableStateFlow<PokemonDetailResponse?>(null)
    val pokemonDetails: StateFlow<PokemonDetailResponse?> = _pokemonDetails

    fun fetchPokemonDetails(name: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPokemonDetails(name)
                _pokemonDetails.value = response
            } catch (e: Exception) {
                e.printStackTrace()
                _pokemonDetails.value = null // Gérer les erreurs
            }
        }
    }
}