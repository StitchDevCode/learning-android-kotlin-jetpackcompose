package com.julio.material3app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun currentRoute(navController: NavHostController): String? =
    navController.currentBackStackEntryAsState().value?.destination?.route
