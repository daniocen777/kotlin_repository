package com.danicode.horocopoapp.data.network.response

import com.danicode.horocopoapp.domain.model.PredictionModel
import com.google.gson.annotations.SerializedName

data class PredictionResponse(
    @SerializedName("date")
    val date: String,

    @SerializedName("horoscope")
    val horoscope: String,

    @SerializedName("sign")
    val sign: String
) {
    // Crear funcion de extension ppara mapear Response (data) a Model (domain)
    fun toDomain(): PredictionModel {
        return PredictionModel(horoscope = this.horoscope, sign = this.sign)
    }
}