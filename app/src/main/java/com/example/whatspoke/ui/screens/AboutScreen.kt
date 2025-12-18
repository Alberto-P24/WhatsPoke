package com.example.whatspoke.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.whatspoke.R

@Composable
fun AboutScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val email = stringResource(R.string.about_contact_email)
    val subject = "Información sobre la Aplicación"
    val body = "Hola,\n\nMe gustaría obtener información sobre la aplicación.\n\nGracias."

    Surface(modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = stringResource(R.string.app_name), style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Temática: Repositorio sobre Pokemon", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Versión: ${stringResource(R.string.app_version)}", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(16.dp))

            Text("Contact Support:", style = MaterialTheme.typography.labelLarge)
            IconButton(onClick = {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:$email")
                    putExtra(Intent.EXTRA_SUBJECT, subject)
                    putExtra(Intent.EXTRA_TEXT, body)
                }
                try {
                    context.startActivity(Intent.createChooser(intent, "Enviar correo con:"))
                } catch (e: Exception) {
                    // Handle case where no email app is found
                }
            }) {
                Icon(Icons.Filled.Email, contentDescription = stringResource(R.string.send_email))
            }
        }
    }
}
