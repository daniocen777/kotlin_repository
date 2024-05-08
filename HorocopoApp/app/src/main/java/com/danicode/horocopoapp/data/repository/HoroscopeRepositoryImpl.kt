package com.danicode.horocopoapp.data.repository

import android.util.Log
import com.danicode.horocopoapp.data.network.IHoroscopeApiService
import com.danicode.horocopoapp.domain.model.PredictionModel
import com.danicode.horocopoapp.domain.repository.IHoroscopeRepository
import javax.inject.Inject

class HoroscopeRepositoryImpl @Inject constructor(private val apiService: IHoroscopeApiService) :
    IHoroscopeRepository {

    override suspend fun getPrediction(sign: String): PredictionModel? {
        // Ejecutar tarea
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure {
                Log.i(
                    "ERROR",
                    "Error en HoroscopeRepositoryImpl::getPrediction => ${it.message}"
                )
            }

        return null
    }
}