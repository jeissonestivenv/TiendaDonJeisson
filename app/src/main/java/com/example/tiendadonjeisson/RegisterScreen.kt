package com.example.tiendadonjeisson.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RegisterScreen(navController: NavController, registeredUsers: MutableList<User>) {
    var nombre by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Registro de cliente", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre completo") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = contraseña,
            onValueChange = { contraseña = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                if (nombre.isNotBlank() && correo.isNotBlank() && contraseña.isNotBlank()) {
                    val existe = registeredUsers.any { it.correo == correo }
                    if (existe) {
                        mensaje = "Este correo ya está registrado"
                    } else {
                        registeredUsers.add(User(nombre, correo, contraseña))
                        mensaje = "Registro exitoso"
                        navController.navigate("login")
                    }
                } else {
                    mensaje = "Por favor llena todos los campos"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar")
        }

        Spacer(Modifier.height(8.dp))
        Text(mensaje)
        Spacer(Modifier.height(8.dp))

        TextButton(onClick = { navController.navigate("login") }) {
            Text("Ya tengo cuenta, ir al login")
        }
    }
}


