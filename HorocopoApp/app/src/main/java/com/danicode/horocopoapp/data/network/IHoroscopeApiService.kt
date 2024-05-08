package com.danicode.horocopoapp.data.network

import com.danicode.horocopoapp.data.network.response.PredictionResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface IHoroscopeApiService {

    @GET("/{sign}")
    suspend fun getHoroscope(@Path("sign") sign: String): PredictionResponse
}