package com.example.application_eval_diiage_p2_voyard_romain.ui.screens

import android.content.Context
import android.content.Context.VIBRATOR_SERVICE
import android.os.Vibrator
import androidx.compose.foundation.Image
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
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.application_eval_diiage_p2_voyard_romain.R
import com.example.application_eval_diiage_p2_voyard_romain.Routes
import com.example.application_eval_diiage_p2_voyard_romain.domain.models.Pokemon
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

        // Si la liste de pokemon est vide, afficher un message de chargement
        if (pokemonList.isEmpty()) {
            Text(text = "Chargement des Pokémons...")
        } else {
            // Utiliser la fonction ContentGrid pour afficher la liste des Pokémon
            ContentGrid(
                pokemons = pokemonList,
                onpokemonClick = { pokemonId ->
                    navController.navigate("DetailPokemonRoute/$pokemonId") // Permet d'ouvrir l'écran détail avec le pokemon sélectionné
                }
            )
        }
    }
}

@Composable
fun ContentGrid(
    pokemons: List<Pokemon>, // Liste des objets Pokemon
    onpokemonClick: (Int) -> Unit // Fonction appelée lorsqu'on clique sur un pokemon
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(pokemons) { pokemon ->
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
                        // Jouer le son et vibration lors du clic sur un Pokémon
                        SoundManager(context).playButtonClickedSound()
                        VibrationManager(context).vibrateOnButtonClicked()
                        onpokemonClick(pokemon.id)
                    }
            ) {
                // Afficher le nom du Pokémon et son image
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Afficher l'image du Pokémon
                    Image(
                        painter = rememberAsyncImagePainter(pokemon.image),
                        contentDescription = pokemon.name,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                    )

                    // Afficher le nom du Pokémon
                    Text(
                        text = pokemon.name,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGrid() {
    ContentGrid(
        pokemons = listOf(
            Pokemon(
                name = "Pikachu",
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png",
                id = TODO(),
                types = TODO(),
                abilities = TODO(),
                url = TODO(),
                created = TODO()
            ),
            Pokemon(
                name = "Bulbizarre",
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
                id = TODO(),
                types = TODO(),
                abilities = TODO(),
                url = TODO(),
                created = TODO()
            )
        ),
        onpokemonClick = { pokemonName -> println("Clicked on: $pokemonName") }
    )
}