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
import com.example.whatspoke.model.Pokemon
import com.example.whatspoke.model.PokemonRepository
import com.example.whatspoke.ui.components.PokemonCard

@Composable
fun ElemListScreen(
    onNavigateToDetail: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    // In a real app, this state would be in a ViewModel
    val pokemonList = remember { PokemonRepository.pokemonList.toMutableStateList() }

    if (pokemonList.isEmpty()) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No Pokemon found.")
        }
    } else {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(pokemonList) { pokemon ->
                PokemonCard(
                    pokemon = pokemon,
                    onClick = { onNavigateToDetail(pokemon.id) },
                    onFavoriteClick = {
                        // Toggle logic (updates the mutable list trigger recomposition)
                        PokemonRepository.toggleFavorite(pokemon)
                        // Force recomposition hack for simple list (in ViewModel use Flow/State)
                        val index = pokemonList.indexOf(pokemon)
                        if (index != -1) {
                           pokemonList[index] = pokemon.copy(isFavorite = pokemon.isFavorite)
                        }
                    }
                )
            }
        }
    }
}
