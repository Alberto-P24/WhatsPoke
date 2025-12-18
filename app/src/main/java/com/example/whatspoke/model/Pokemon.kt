package com.example.whatspoke.model

data class Pokemon(
    val id: Int,
    val name: String,
    val description: String,
    val imageUrl: String, // In a real app this would be a URL, here it might be a placeholder
    val type: String,
    var isFavorite: Boolean = false,
    val comments: MutableList<String> = mutableListOf()
)

object PokemonRepository {
    val pokemonList = listOf(
        Pokemon(
            1, "Pikachu", 
            "Electric type Pokemon. Uses lightning attacks.", 
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
            "Electric",
            true,
            mutableListOf("So cute!", "Pika Pika!")
        ),
        Pokemon(
            2, "Charmander", 
            "Fire type Pokemon. Has a flame on its tail.", 
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
            "Fire"
        ),
        Pokemon(
            3, "Squirtle", 
            "Water type Pokemon. Uses water gun.", 
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
            "Water"
        ),
        Pokemon(
            4, "Bulbasaur", 
            "Grass type Pokemon. Has a plant bulb on its back.", 
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            "Grass"
        ),
        Pokemon(
            5, "Jigglypuff", 
            "Fairy type. Sings lullabies.", 
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/39.png",
            "Fairy"
        ),
        Pokemon(
            6, "Meowth", 
            "Normal type. The cat Pokemon.", 
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/52.png",
            "Normal"
        )
    )

    fun getPokemonById(id: Int): Pokemon? {
        return pokemonList.find { it.id == id }
    }
    
    fun toggleFavorite(pokemon: Pokemon) {
        // Since we are using a simple list, this won't persist across restarts without a database/datastore
        // but works for the session.
        pokemon.isFavorite = !pokemon.isFavorite
    }
}
