package com.example.tiendadonjeisson.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CartScreen(navController: NavController, cartItems: MutableList<Product>) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Carrito de compras", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))

        if (cartItems.isEmpty()) {
            Text("El carrito está vacío")
        } else {
            LazyColumn {
                items(cartItems) { producto ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("${producto.nombre} x${producto.cantidad}")
                            Text("Precio: $${producto.precio * producto.cantidad}")
                        }
                        Button(onClick = { cartItems.remove(producto) }) {
                            Text("Eliminar")
                        }
                    }
                }
            }

            Spacer(Modifier.height(20.dp))
            val total = cartItems.sumOf { it.precio * it.cantidad }
            Text("Total: $${total}")
        }

        Spacer(Modifier.height(20.dp))
        Button(
            onClick = { navController.navigate("productos") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver a productos")
        }
    }
}


