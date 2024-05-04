package com.danicode.horocopoapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.danicode.horocopoapp.data.providers.HoroscopeProvider
import com.danicode.horocopoapp.domain.model.HoroscopeInfo
import com.danicode.horocopoapp.domain.model.HoroscopeInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

// Colocar anotacion "@HiltViewModel" para preparar la conexion con DaggerHilt
@HiltViewModel
class HoroscopeViewModel @Inject constructor(horoscopeProvider: HoroscopeProvider) :
    ViewModel() {
    // Flow para que fluyan los datos que se comuniquen con la vista
    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    // Metodo especial de los viewModel => se llama cuando se cree el viewModel
    init {
        _horoscope.value = horoscopeProvider.getHoroscope()
    }
}