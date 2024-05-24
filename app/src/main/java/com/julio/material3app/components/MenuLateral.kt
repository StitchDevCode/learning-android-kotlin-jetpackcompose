package com.julio.material3app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.julio.material3app.R
import com.julio.material3app.model.ItemMenuLateral
import com.julio.material3app.navigation.currentRoute
import kotlinx.coroutines.launch

@Composable
fun MenuLateral(
    navController: NavHostController,
    drawerState: DrawerState,
    contenido: @Composable () -> Unit
){
    val scope = rememberCoroutineScope()//Corrutina

    val itemMenuLateral = listOf(
        ItemMenuLateral.item1,
        ItemMenuLateral.item2,
        ItemMenuLateral.item3,
        ItemMenuLateral.item4,
    )
    //Menu Lateral
    ModalNavigationDrawer(
        drawerState= drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo app"
                )
                itemMenuLateral.forEach{ item ->
                    val selected = currentRoute(navController) == item.ruta

                    NavigationDrawerItem(
                        modifier = Modifier.padding(10.dp),
                        icon = {
                               Icon(imageVector = item.icons, contentDescription = null )
                        },
                        label = { Text(text = item.title) },
                        selected = selected,
                        onClick = {
                            //Corrutina
                            scope.launch {
                                drawerState.close()
                            }
                            navController.navigate(item.ruta)
                        })
                }
            }
        }
    ) {
        contenido()
    }
}