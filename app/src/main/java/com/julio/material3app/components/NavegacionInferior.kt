package com.julio.material3app.components

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.julio.material3app.model.ItemBottonNav
import com.julio.material3app.navigation.currentRoute

@Composable
fun NavegacionInferior(
    navHostController: NavHostController
){
   val menuItem = listOf(
       ItemBottonNav.itemNav1,
       ItemBottonNav.itemNav2,
       ItemBottonNav.itemNav3,
   )


    BottomAppBar (
//        containerColor = MaterialTheme.colorScheme.primary
    ){
        NavigationBar (
        containerColor = MaterialTheme.colorScheme.inverseOnSurface
        ){
            menuItem.forEach{ item->

                val selected = currentRoute(navHostController) == item.ruta

                NavigationBarItem(
                    selected = selected,
                    onClick = { navHostController.navigate(item.ruta) },
                    icon = {
                        Icon(imageVector = item.icon, contentDescription = null)
                    },
                    label = {
                        Text(text = item.title)
                    }
                )
            }
        }
    }
}