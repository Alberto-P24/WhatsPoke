package com.example.whatspoke.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    val isLoggedIn = remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Surface(
            modifier = Modifier.size(100.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer,
            shadowElevation = 4.dp
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                modifier = Modifier.padding(24.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        if (isLoggedIn.value) {
            Text("Welcome, Trainer!", style = MaterialTheme.typography.headlineSmall)
            Text("User ID: 12345", style = MaterialTheme.typography.bodyMedium)
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Button(
                onClick = { isLoggedIn.value = false },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("Log Out")
            }
        } else {
            Text("Guest User", style = MaterialTheme.typography.headlineSmall)
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Button(onClick = { isLoggedIn.value = true }) {
                Text("Log In")
            }
        }
    }
}
