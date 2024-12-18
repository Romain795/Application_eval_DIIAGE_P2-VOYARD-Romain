package com.example.application_eval_diiage_p2_voyard_romain.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.application_eval_diiage_p2_voyard_romain.data.Pokemon
import com.example.application_eval_diiage_p2_voyard_romain.data.RetrofitInstance
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
                val response = RetrofitInstance.api.getPokemonList()
                _pokemonList.value = response.results // Mettez à jour l'état
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}