package com.danicode.restaurant.model

import com.google.gson.annotations.SerializedName

data class Categoria(
    @SerializedName("nom_categoria")
    val nombreCategoria: String,

    @SerializedName("img_categoria")
    val imgCategoria: String
)
