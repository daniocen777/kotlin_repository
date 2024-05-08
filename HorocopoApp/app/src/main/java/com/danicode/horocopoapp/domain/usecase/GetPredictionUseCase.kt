package com.danicode.horocopoapp.domain.usecase

import com.danicode.horocopoapp.domain.repository.IHoroscopeRepository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: IHoroscopeRepository) {
    suspend operator fun invoke(sign: String) = repository.getPrediction(sign)
}