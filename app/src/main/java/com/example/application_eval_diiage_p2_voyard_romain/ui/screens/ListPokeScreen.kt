package com.example.application_eval_diiage_p2_voyard_romain.ui.screens

import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.os.Vibrator
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.application_eval_diiage_p2_voyard_romain.R
import com.example.application_eval_diiage_p2_voyard_romain.Routes
import com.example.application_eval_diiage_p2_voyard_romain.nativemanager.SoundManager
import com.example.application_eval_diiage_p2_voyard_romain.nativemanager.VibrationManager

@Composable
fun ListPokeScreen(navController: NavController) {
    val viewModel: ListPokeViewmodels = viewModel()
    val pokemonList by viewModel.pokemonList.collectAsState()
    val context = LocalContext.current

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Liste de Pokémons", modifier = Modifier.padding(16.dp))

        // Si la liste de pokemon est remplie cela affiche la liste sinon cela affiche un chargement
        if (pokemonList.isEmpty()) {
            Text(text = "Chargement des Pokémons...")
        } else {
            ContentGrid(
                pokemons = listOf("Pikachu", "Léviator", "Yveltal", "Solgaleo", "yo", "yo", "yo", "yo", "yo", "yo", "yo", "yo", "yo") /*pokemonList.map { it.name }*/,
                onpokemonClick = { pokemonName ->
                    navController.navigate("DetailPokemonRoute/hello") // Permet d'ouvrir l'écran détail avec le pokemon sélectionner
                }
            )
        }
    }
}

@Composable
fun ContentGrid(
    pokemons: List<String>, // Liste des pokemons
    onpokemonClick: (String) -> Unit // Fonction qui sera appeler lorsqu'on clique sur un pokemon
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(pokemons) { challenge ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 2.dp,
                        color = colorResource(id = R.color.black),
                        shape = RoundedCornerShape(8.dp) // Coins arrondis
                    )
                    .padding(8.dp)
                    .clickable {
                        //SoundManager(context).playButtonClickedSound()
                        VibrationManager(context).vibrateOnButtonClicked()
                        onpokemonClick(challenge)
                    }
            ) {
                Text(
                    text = challenge,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGrid() {
    ContentGrid(
        pokemons = listOf("Pikachu", "Léviator", "Yveltal", "Solgaleo", "yo", "yo", "yo", "yo", "yo", "yo", "yo", "yo", "yo"),
        onpokemonClick = { pokemonName -> println("Clicked on: $pokemonName") }
    )
}