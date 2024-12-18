package com.example.application_eval_diiage_p2_voyard_romain.domain.models

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<Type>,
    val abilities: List<Ability>,
    val image: String,
    val url: String,
    val created: String
)

data class Type(
    val name: String
)

data class Ability(
    val name: String
)