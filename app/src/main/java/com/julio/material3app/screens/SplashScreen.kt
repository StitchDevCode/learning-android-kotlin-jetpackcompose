package com.julio.material3app.screens

import android.content.Intent
import android.util.Log
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.OverscrollEffect
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.julio.material3app.MainActivity
import com.julio.material3app.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {
    // Obtiene el contexto actual
    val context = LocalContext.current

    // Crea un objeto Animatable que controlará la escala de la animación
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // Ejecuta la animación cuando se lanza el efecto
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.9f, // Valor objetivo de la escala
            animationSpec = tween(
                durationMillis = 800, // Duración de la animación en milisegundos
                easing = {
                    // Función de interpolación para una animación con efecto de sobreimpulso
                    OvershootInterpolator(8f).getInterpolation(it)
                }
            )
        )

        // Retrasa la ejecución durante 1000 milisegundos (1 segundo)
        delay(1000L)

        // Crea un Intent para iniciar la MainActivity
        val intent = Intent(
            context,
            MainActivity::class.java
        )
        // Inicia la MainActivity
        context.startActivity(intent)
    }

    // Columna que organiza los elementos de la pantalla
    Column(
        verticalArrangement = Arrangement.Center, // Alinea verticalmente en el centro
        horizontalAlignment = Alignment.CenterHorizontally, // Alinea horizontalmente en el centro
        modifier = Modifier
            .scale(scale.value) // Aplica la escala animada
    ) {
        // Muestra una imagen
        Image(
            painter = painterResource(id = R.drawable.gatito),
            contentDescription = "Gatito"
        )

        // Muestra un texto
        Text(
            text = "Bienvenido",
            color = MaterialTheme.colorScheme.primary
        )

        // Muestra un botón con un log en el clic
        OutlinedButton(onClick = {
            Log.d("Hola", "Boton Funcionando") // Log para depuración
        }) {
            Text(text = "Continuar") // Texto del botón
        }
    }
}
