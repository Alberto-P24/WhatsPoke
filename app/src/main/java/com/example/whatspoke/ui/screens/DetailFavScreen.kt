package com.example.whatspoke.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.whatspoke.model.PokemonRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailFavScreen(
    pokemonId: Int,
    modifier: Modifier = Modifier
) {
    val pokemon = PokemonRepository.getPokemonById(pokemonId)
    val showCommentDialog = remember { mutableStateOf(false) }
    
    // Simple state for comment input, usually in a Dialog
    val commentText = remember { mutableStateOf("") }
    val isAddingComment = remember { mutableStateOf(false) }

    if (pokemon == null) {
        Text("Pokemon not found")
        return
    }

    val comments = remember { pokemon.comments.toMutableStateList() }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { isAddingComment.value = !isAddingComment.value },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Comment")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Text(text = "Favorite: ${pokemon.name}", style = MaterialTheme.typography.headlineMedium)
                Text(text = "Comments", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(8.dp))
            }
            
            if (isAddingComment.value) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedTextField(
                            value = commentText.value,
                            onValueChange = { commentText.value = it },
                            modifier = Modifier.weight(1f),
                            label = { Text("New Comment") }
                        )
                        IconButton(onClick = {
                            if (commentText.value.isNotBlank()) {
                                pokemon.comments.add(commentText.value)
                                comments.add(commentText.value)
                                commentText.value = ""
                                isAddingComment.value = false
                            }
                        }) {
                            Icon(Icons.Default.Send, contentDescription = "Post")
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }

            items(comments) { comment ->
               Text(
                   text = "- $comment",
                   style = MaterialTheme.typography.bodyMedium,
                   modifier = Modifier.padding(vertical = 4.dp)
               )
            }
        }
    }
}
