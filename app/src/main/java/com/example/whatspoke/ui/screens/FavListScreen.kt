package com.example.whatspoke.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.whatspoke.model.PokemonRepository
import com.example.whatspoke.ui.components.PokemonCard

@Composable
fun FavListScreen(
    onNavigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    // Filter only favorites
    // Note: In real app, use ViewModel. Here we rely on Repository static list for simplicity.
    // We need a force refresh mechanism or better state management, but for assignment:
    val favPokemonList = remember { 
        PokemonRepository.pokemonList.filter { it.isFavorite }.toMutableStateList() 
    }

    if (favPokemonList.isEmpty()) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No Favorites yet.")
        }
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(favPokemonList) { pokemon ->
                PokemonCard(
                    pokemon = pokemon,
                    onClick = { onNavigateToDetail(pokemon.id) },
                    onFavoriteClick = {
                        PokemonRepository.toggleFavorite(pokemon)
                        favPokemonList.remove(pokemon) // Remove from UI immediately
                    }
                )
            }
        }
    }
}
