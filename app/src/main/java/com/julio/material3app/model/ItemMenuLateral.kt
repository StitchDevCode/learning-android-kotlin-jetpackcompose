package com.julio.material3app.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.PriceCheck
import androidx.compose.material.icons.outlined.RealEstateAgent
import androidx.compose.ui.graphics.vector.ImageVector
import com.julio.material3app.navigation.NavScreen

sealed class ItemMenuLateral(
    val icons: ImageVector,
    val title: String,
    val ruta: String
) {
    object item1: ItemMenuLateral(
        Icons.Outlined.RealEstateAgent,
        "Consulta de saldo",
        NavScreen.HomeScreen.name
    )
    object item2: ItemMenuLateral(
        Icons.Outlined.CreditCard,
        "Pagar Tarjeta",
        NavScreen.PagarTarjeta.name
    )
    object item3: ItemMenuLateral(
        Icons.Outlined.PriceCheck,
        "Pagar Servicios",
        NavScreen.PagosServicos.name
    )
    object item4: ItemMenuLateral(
        Icons.Outlined.AttachMoney,
        "Transferencia",
        NavScreen.Transferencia.name
    )
}