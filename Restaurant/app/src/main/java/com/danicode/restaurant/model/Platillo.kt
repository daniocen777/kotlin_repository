package com.danicode.restaurant.model

import com.google.gson.annotations.SerializedName

data class Platillo(
    @SerializedName("nom_platillo")
    val nombrePlatillo: String,

    @SerializedName("descripcion_platillo")
    val descripcionPlatillo: String,

    @SerializedName("precio")
    val precio: String,

    @SerializedName("nom_categoria")
    val nomrbeCategoria: String

)
