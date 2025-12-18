package com.example.whatspoke.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.whatspoke.model.PokemonRepository
import com.example.whatspoke.ui.components.FavoriteButton

@Composable
fun DetailItemScreen(
    pokemonId: Int,
    onNavigateBack: () -> Unit, // Optional if handled by navigation
    modifier: Modifier = Modifier
) {
    val pokemon = PokemonRepository.getPokemonById(pokemonId)

    if (pokemon == null) {
        Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Pokemon not found")
        }
    } else {
        // Local state for immediate feedback
        val isFav = remember { mutableStateOf(pokemon.isFavorite) }

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(MaterialTheme.colorScheme.secondaryContainer, shape = MaterialTheme.shapes.medium),
                contentAlignment = Alignment.Center
            ) {
                // Placeholder Image
                Text(pokemon.name, style = MaterialTheme.typography.displayMedium)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = pokemon.name, style = MaterialTheme.typography.headlineLarge)
            Text(text = "Type: ${pokemon.type}", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(text = pokemon.description, style = MaterialTheme.typography.bodyLarge)

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    PokemonRepository.toggleFavorite(pokemon)
                    isFav.value = pokemon.isFavorite
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text(if (isFav.value) "Remove from Favorites" else "Add to Favorites")
            }
        }
    }
}
