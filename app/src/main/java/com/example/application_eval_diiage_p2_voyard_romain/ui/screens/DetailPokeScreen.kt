package com.example.application_eval_diiage_p2_voyard_romain.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.application_eval_diiage_p2_voyard_romain.R
import com.example.application_eval_diiage_p2_voyard_romain.domain.models.Ability
import com.example.application_eval_diiage_p2_voyard_romain.domain.models.Pokemon
import com.example.application_eval_diiage_p2_voyard_romain.domain.models.Type

@Composable
fun DetailPokeScreen(
    navController: NavController,
    pokemonId: Int // L'ID du Pokémon est passé en paramètre
) {
    val context = LocalContext.current
    val btnRetour = context.getString(R.string.btn_retour)

    // ViewModel pour gérer les données
    val viewModel: DetailPokeViewmodels = viewModel()

    LaunchedEffect(true) {
        viewModel.fetchPokemonDetail()
    }

    val pokemon by viewModel.pokemonDetail.collectAsState()

    // Interface utilisateur
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Bouton pour retourner à la liste des Pokémon
            Button(
                modifier = Modifier.padding(10.dp),
                onClick = {
                    navController.navigate("ListPokemonRoute")
                }
            ) {
                Text("< $btnRetour")
            }

            // Affichage des détails du Pokémon
            if (pokemon == null) {
                Text(text = "Chargement des informations...")
            } else {
                PokemonDetailContent(pokemon = pokemon!!)
            }
        }
    }
}

@Composable
fun PokemonDetailContent(pokemon: Pokemon) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Image du Pokémon
        Image(
            painter = rememberImagePainter(data = pokemon.image),
            contentDescription = pokemon.name,
            modifier = Modifier.padding(16.dp)
        )

        // Nom du Pokémon
        Text(
            text = pokemon.name,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )

        // Types du Pokémon
        Text(
            text = "Types : ${pokemon.types.joinToString { it.name }}",
            fontSize = 16.sp
        )

        // Capacités du Pokémon
        Text(
            text = "Capacités : ${pokemon.abilities.joinToString { it.name }}",
            fontSize = 16.sp
        )

        // URL et date de création
        Row {
            Text(
                text = "Créé le : ${pokemon.created}",
                fontSize = 14.sp
            )
        }
        Row {
            Text(
                text = "URL : ${pokemon.url}",
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetails() {
    val mockPokemon = Pokemon(
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

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        PokemonDetailContent(pokemon = mockPokemon)
    }
}
