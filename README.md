# Pokémon App - Évaluation DIiAGE P2

## Description

Cette application permet de visualiser et d'interagir avec une liste de Pokémon, en affichant leurs détails, tels que leur nom, type, capacités, et image. Elle utilise un modèle d'architecture MVVM et simule des appels à la PokeAPI (en utilisant des mockeds) pour récupérer les données des Pokémon.

## Technologies

- **Langage** : Kotlin
- **Framework UI** : Jetpack Compose
- **Architecture** : MVVM
- **API de données** : Simulation via des données mockées (PokéAPI)
- **Image loading** : Coil pour charger les images des Pokémon depuis une URL

## Fonctionnalités

### Liste des Pokémon
- Affichage d'une liste de Pokémon avec leurs images et noms.
- Possibilité de cliquer sur un Pokémon pour voir ses détails.

### Détails du Pokémon
- Affichage des informations détaillées du Pokémon sélectionné, telles que :
  - Nom
  - Type(s)
  - Capacités
  - Image
  - URL et date de création

### Navigation
- Navigation fluide entre l'écran de liste et l'écran de détail d'un Pokémon.
- Bouton de retour à la liste des Pokémon sur l'écran de détail.

## Choix techniques

### Architecture
L'architecture du projet suit le modèle **MVVM** 
