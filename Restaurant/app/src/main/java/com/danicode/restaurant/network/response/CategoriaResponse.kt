package com.danicode.restaurant.network.response

import com.danicode.restaurant.model.Categoria

data class CategoriaResponse(
    val codigo: String,
    val mensaje: String,
    val datos: ArrayList<Categoria>
)
