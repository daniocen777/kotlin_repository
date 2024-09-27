package com.danicode.restaurant.network.response

import com.danicode.restaurant.model.Categoria
import com.danicode.restaurant.model.Platillo

data class PlatilloResponse(
    val codigo: String,
    val mensaje: String,
    val datos: ArrayList<Platillo>
)
