package com.example.whatspoke.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.whatspoke.model.Pokemon

@Composable
fun PokemonCard(
    pokemon: Pokemon,
    onClick: () -> Unit,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Customization:
    // 1. Shapes: Rounded corners of 16.dp for a friendly look.
    // 2. Colors: Uses Surface Variant or Secondary Container for distinct look.
    // 3. Elevation: 4.dp to lift it from background.
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Placeholder for Image since we don't have coil/glide dependency added yet
            // Using a colored box or text if no image library
            // Assuming for this assignment we rely on default or simple placeholders
             // Or we add Coil. Let's stick to Text implementation for now to avoid complexity unless user asked for image loading explicitly (they have a URL but didn't ask for Coil).
            // Actually, prompts says "Información básica del elemento". Visuals are good.
            // I'll put a simple placeholder icon.
            
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = pokemon.name,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = pokemon.type,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.7f)
                )
            }
            
            Spacer(modifier = Modifier.width(8.dp))
            
            FavoriteButton(
                isFavorite = pokemon.isFavorite,
                onToggle = onFavoriteClick
            )
        }
    }
}
