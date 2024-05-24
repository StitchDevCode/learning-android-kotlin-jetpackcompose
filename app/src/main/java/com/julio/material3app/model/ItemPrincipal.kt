package com.julio.material3app.model

sealed class ItemPrincipal(
    val image: Int?,
    val title: String,
    val details: String,
){
    object item1: ItemPrincipal(
        null,
        "Cuentas",
        "Detelle Cuenta"
    )
    object item2: ItemPrincipal(
        null,
        "Tarjeta de credito",
        "Detelle Tarjeta"
    )
    object item3: ItemPrincipal(
        null,
        "Recompensas",
        "Detelle Recompensas"
    )
    object item4: ItemPrincipal(
        null,
        "Inversiones",
        "Detelle Inversiones"
    )
    object item5: ItemPrincipal(
        null,
        "Creditos",
        "Detelle Creditos"
    )
}
