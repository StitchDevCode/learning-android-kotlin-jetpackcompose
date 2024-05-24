package com.julio.material3app.screens

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.julio.material3app.model.ItemPrincipal
import com.julio.material3app.model.ItemPrincipal.*

// Función compuesta que define la pantalla de inicio
@Composable
fun HomeScreen(){
    // Lista de elementos principales
    val lista_item_principal = listOf(
        item1,
        item2,
        item3,
        item4,
        item5,
    )

    // Columna perezosa que despliega la lista de elementos
    LazyColumn(
        // Añade relleno al contenido de la columna
        contentPadding = PaddingValues(16.dp)
    ) {
        // Por cada elemento en la lista, ejecuta el siguiente bloque de código
        items(lista_item_principal){item ->
            // Muestra un elemento de lista y un divisor
            ListItemRow(item)
            Divider()
        }
    }
}

// Función compuesta que representa un elemento individual de la lista
@Composable
fun ListItemRow(item: ItemPrincipal){
    // Estado que indica si se debe mostrar más información sobre el elemento
    var masInfo = remember {
        mutableStateOf(false)
    }

    // Columna que organiza su contenido en una sola columna vertical
    Column(
        // Aplica relleno vertical y animación de cambio de tamaño al contenido de la columna
        modifier = Modifier
            .padding(vertical = 8.dp)
            .animateContentSize(animationSpec = tween(120,0, LinearEasing))
    ) {
        // Fila que organiza su contenido en una fila horizontal
        Row(
            // Alinea verticalmente el contenido en el centro
            verticalAlignment = Alignment.CenterVertically
        ){
            // Muestra el título del elemento principal
            Text(
                text = item.title,
                // Asigna todo el espacio disponible a este texto
                modifier = Modifier
                    .weight(1f)
            ) //Importancia

            // Botón que muestra un ícono para agregar o quitar información
            IconButton(onClick = {
                // Cambia el estado para mostrar u ocultar detalles adicionales
                masInfo.value =  !masInfo.value
            }) {
                // Muestra un ícono de "agregar" o "eliminar" dependiendo del estado masInfo
                Icon(
                    // Determina qué ícono mostrar según el estado masInfo
                    if(masInfo.value)
                        Icons.Default.Remove
                    else
                        Icons.Default.Add,
                    // Descripción del contenido del ícono
                    contentDescription = "Icono add"
                )
            }
        }

        // Si masInfo es verdadero, muestra detalles adicionales del elemento
        if(masInfo.value){
            // Muestra detalles adicionales del elemento principal
            Row {
                Text(text = item.details)
            }
        }
    }
}