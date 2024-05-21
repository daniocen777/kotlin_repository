package com.danicode.marveluniverseclean.ui.charactersList

import com.danicode.marveluniverseclean.domain.model.Character

sealed class CharactersListState {
    object Loading : CharactersListState()
    data class Error(val error: String) : CharactersListState()
    data class Success(val characters: List<Character>) :
        CharactersListState()
}

