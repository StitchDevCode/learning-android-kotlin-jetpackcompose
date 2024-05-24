package com.julio.material3app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.julio.material3app.screens.HomeScreen
import com.julio.material3app.screens.PagoTarjetaScreen
import com.julio.material3app.screens.PagosServiciosScreen
import com.julio.material3app.screens.TransferenciaScreen

@Composable
fun BancoNavigation(
    navController: NavHostController
){
   NavHost(
     navController= navController,
       startDestination = NavScreen.HomeScreen.name
   ){
        composable(NavScreen.HomeScreen.name){
            HomeScreen()
        }
       composable(NavScreen.PagarTarjeta.name){
           PagoTarjetaScreen()
       }
       composable(NavScreen.PagosServicos.name){
           PagosServiciosScreen()
       }
       composable(NavScreen.Transferencia.name){
           TransferenciaScreen()
       }
   }
}

