package com.danicode.marveluniverseclean.ui.charactersList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danicode.marveluniverseclean.domain.use_cases.GetCharactersUseCase
import com.danicode.marveluniverseclean.util.Response.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private var _state = MutableStateFlow<CharactersListState>(CharactersListState.Loading)
    val state: MutableStateFlow<CharactersListState> = _state

    fun getCharacters() {
        viewModelScope.launch {
            CharactersListState.Loading
            val result = withContext(Dispatchers.IO) {
                getCharactersUseCase(0)
            }
            if (result != null) {
                Log.i("getCharacters", result.size.toString())
                _state.value = CharactersListState.Success(result)
            } else {
                Log.i("getCharacters", "ERROR")
                _state.value =
                    CharactersListState.Error("ERROR getCharacters => CharactersViewModel")
            }
        }
    }
}