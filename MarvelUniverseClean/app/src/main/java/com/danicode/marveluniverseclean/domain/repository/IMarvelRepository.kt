package com.danicode.marveluniverseclean.domain.repository

import com.danicode.marveluniverseclean.domain.model.Character

interface IMarvelRepository {

    suspend fun getAllCharacters(offset: Int): List<Character>?
}