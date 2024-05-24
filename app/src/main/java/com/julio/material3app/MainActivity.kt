package com.julio.material3app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.julio.material3app.components.MenuLateral
import com.julio.material3app.components.NavegacionInferior
import com.julio.material3app.components.TopBar
import com.julio.material3app.navigation.BancoNavigation
import com.julio.material3app.screens.HomeScreen
import com.julio.material3app.screens.SplashScreen
import com.julio.material3app.ui.theme.Material3AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Material3AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed)
    MenuLateral(
        navController = navController,
        drawerState = drawerState) {

      Contenido(navController = navController,
          drawerState = drawerState)
    }

}


@Composable
fun Contenido(
     navController: NavHostController,
     drawerState: DrawerState
){
    Scaffold (
        topBar =  {
            TopBar(drawerState = drawerState)
        },
        bottomBar = {
            NavegacionInferior(navController)
        }
    ){ padding ->
        Box(
            modifier =
            Modifier
                .padding(padding)
                .fillMaxSize()){
            BancoNavigation(navController = navController)
        }
    }
}
