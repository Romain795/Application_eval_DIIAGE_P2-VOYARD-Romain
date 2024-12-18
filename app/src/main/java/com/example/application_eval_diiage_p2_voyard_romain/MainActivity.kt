package com.example.application_eval_diiage_p2_voyard_romain

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.application_eval_diiage_p2_voyard_romain.ui.screens.DetailPokeScreen
import com.example.application_eval_diiage_p2_voyard_romain.ui.screens.ListPokeScreen
import com.example.application_eval_diiage_p2_voyard_romain.ui.theme.Application_eval_DIIAGE_P2VOYARDRomainTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Routes.varListPokeRoute,
                builder = {
                    composable(Routes.varListPokeRoute){
                        ListPokeScreen(navController)
                    }
                    composable(Routes.varDetailPokeRoute) {
                            navBackstackEntry ->
                        val pokemonid = navBackstackEntry.arguments?.getInt("pokemon_id")

                        if (pokemonid == null) {
                            navController.popBackStack()
                            Log.d("Details_pokemon", "on devrais recevoir un id de pokémon")
                            return@composable
                        }

                        DetailPokeScreen(
                            navController = navController,
                            pokemonId = pokemonid
                        )
                    }
                })
        }
    }
}
