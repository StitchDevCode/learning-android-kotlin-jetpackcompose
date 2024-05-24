package com.julio.material3app.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AttachMoney
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.PriceCheck
import androidx.compose.ui.graphics.vector.ImageVector
import com.julio.material3app.navigation.NavScreen

sealed class ItemBottonNav(
    val icon: ImageVector,
    val title: String,
    val ruta: String
) {
    object itemNav1: ItemBottonNav(
        Icons.Outlined.AttachMoney,
        "Transferencia",
        NavScreen.Transferencia.name
    )
    object itemNav2: ItemBottonNav(
        Icons.Outlined.PriceCheck,
        "Pagos Servicos",
        NavScreen.PagosServicos.name
    )
    object itemNav3: ItemBottonNav(
        Icons.Outlined.CreditCard,
        "Pagar Tarjeta",
        NavScreen.PagarTarjeta.name
    )
}