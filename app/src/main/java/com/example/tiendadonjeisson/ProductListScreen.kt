package com.example.tiendadonjeisson.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ProductListScreen(navController: NavController, cartItems: MutableList<Product>) {
    val productos = listOf(
        Product("Camiseta", 25000.0),
        Product("Pantalón", 60000.0),
        Product("Zapatos", 120000.0),
        Product("Gorra", 18000.0)
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Listado de Productos", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        LazyColumn {
            items(productos) { producto ->
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(text = producto.nombre)
                        Text(text = "Precio: $${producto.precio}")
                        Spacer(Modifier.height(8.dp))
                        Button(
                            onClick = {
                                val existente = cartItems.find { it.nombre == producto.nombre }
                                if (existente != null) {
                                    existente.cantidad++
                                } else {
                                    cartItems.add(producto.copy())
                                }
                            },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Agregar al carrito")
                        }
                    }
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("carrito") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver carrito (${cartItems.size})")
        }
    }
}





