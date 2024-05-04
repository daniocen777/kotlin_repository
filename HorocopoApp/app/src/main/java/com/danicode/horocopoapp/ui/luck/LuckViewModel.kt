package com.danicode.horocopoapp.ui.luck

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// Colocar anotacion "@HiltViewModel" para preparar la conexion con DaggerHilt
@HiltViewModel
class LuckViewModel @Inject constructor() : ViewModel() {
}