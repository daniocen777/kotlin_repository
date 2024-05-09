package com.danicode.horocopoapp.ui.detail

import com.danicode.horocopoapp.domain.model.HoroscopeModel

sealed class HoroscopeDetailState {
    object Loading : HoroscopeDetailState()
    data class Error(val error: String) : HoroscopeDetailState()
    data class Success(val data: String, val sign: String, val horoscopeModel: HoroscopeModel) :
        HoroscopeDetailState()
}