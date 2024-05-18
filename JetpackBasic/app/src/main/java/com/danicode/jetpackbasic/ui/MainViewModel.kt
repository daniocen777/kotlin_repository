package com.danicode.jetpackbasic.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // Solo modificar los estados en el viewModel
    var state by mutableStateOf("Pedro")
        private set

    fun updateName() {
        state = "Juan"
    }
}