package com.example.application_eval_diiage_p2_voyard_romain.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.application_eval_diiage_p2_voyard_romain.R

@Composable
fun DetailPokeScreen(
    navController: NavController,
    PokeName: String //Permet de passer en paramètre l'id du pokemon à afficher
) {
    //Permet de gérer la langue de la page en fonction de la langue du context
    val context = LocalContext.current
    val btnretour = context.getString(R.string.btn_retour)

    //bouton permettant de revenir à la liste des pokemon
    Button(
        modifier = Modifier
            .padding(10.dp),
        onClick = {
            navController.navigate("ListPokemonRoute")
        },
        content = {
            Text("<$btnretour")
        }
    )
    //on affiche les informations du pokemon
    Column (
        Modifier.fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        //on affiche pour le moment que son nom
        Text(text=" $PokeName")

    }
}

@Preview(showBackground = true)
@Composable
fun Previewdetails() {
    DetailPokeScreen(
        navController= rememberNavController(),
        PokeName= "Yo"
    )}