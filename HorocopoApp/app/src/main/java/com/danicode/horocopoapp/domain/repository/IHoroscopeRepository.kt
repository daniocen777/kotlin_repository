package com.danicode.horocopoapp.domain.repository

import com.danicode.horocopoapp.domain.model.PredictionModel

interface IHoroscopeRepository {
    suspend fun getPrediction(sign: String): PredictionModel?
}