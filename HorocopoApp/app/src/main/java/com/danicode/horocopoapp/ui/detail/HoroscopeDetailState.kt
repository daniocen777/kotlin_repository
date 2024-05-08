package com.danicode.horocopoapp.ui.detail

sealed class HoroscopeDetailState {
    object Loading : HoroscopeDetailState()
    data class Error(val error: String) : HoroscopeDetailState()
    data class Success(val data: String, val sign: String) : HoroscopeDetailState()
}