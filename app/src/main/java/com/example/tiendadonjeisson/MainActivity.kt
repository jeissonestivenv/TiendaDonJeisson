package com.example.tiendadonjeisson

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tiendadonjeisson.ui.*
import com.example.tiendadonjeisson.ui.theme.TiendaDonJeissonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TiendaDonJeissonTheme {
                Surface {
                    val navController = rememberNavController()

                    // Lista de usuarios registrados
                    val registeredUsers = remember { mutableStateListOf<User>() }

                    // Carrito de compras
                    val cartItems = remember { mutableStateListOf<Product>() }

                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") {
                            LoginScreen(navController, registeredUsers)
                        }
                        composable("registro") {
                            RegisterScreen(navController, registeredUsers)
                        }
                        composable("productos") {
                            ProductListScreen(navController, cartItems)
                        }
                        composable("carrito") {
                            CartScreen(navController, cartItems)
                        }
                    }
                }
            }
        }
    }
}




