/*package com.example.whatspoke

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AboutScreen()
        }
    }
}

@Composable
fun AboutScreen() {
    val context = LocalContext.current
    val email = context.getString(R.string.about_contact_email)
    val subject = "Información sobre la Aplicación"
    val body = "Hola,\n\nMe gustaría obtener información sobre la aplicación.\n\nGracias."

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = stringResource(R.string.app_name), style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Temática: Repositorio sobre Pokemon", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Versión: ${stringResource(R.string.app_version)}", style = MaterialTheme.typography.bodySmall)
            Spacer(modifier = Modifier.height(16.dp))

            // Botón/icono para enviar correo:
            IconButton(onClick = {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:$email")
                    putExtra(Intent.EXTRA_SUBJECT, subject)
                    putExtra(Intent.EXTRA_TEXT, body)
                }
                // Abrir app de correo
                context.startActivity(Intent.createChooser(intent, "Enviar correo con:"))
            }) {
                Icon(Icons.Filled.Email, contentDescription = stringResource(R.string.send_email))
            }
        }
    }
}*/