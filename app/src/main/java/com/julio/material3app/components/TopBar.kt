package com.julio.material3app.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.julio.material3app.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    drawerState: DrawerState
){
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    CenterAlignedTopAppBar(
        title = { Text(text = "Material 3 ❤") },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    drawerState.open()
                }

            }) {
                Icon(
                    imageVector = Icons.Outlined.Menu,
                    contentDescription = null
                )
            }
        }
    )
}