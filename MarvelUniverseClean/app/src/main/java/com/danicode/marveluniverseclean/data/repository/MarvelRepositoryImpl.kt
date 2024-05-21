package com.danicode.marveluniverseclean.data.repository

import android.util.Log
import com.danicode.marveluniverseclean.data.data_source.IMarvelApi
import com.danicode.marveluniverseclean.domain.model.Character
import com.danicode.marveluniverseclean.domain.repository.IMarvelRepository
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(private val api: IMarvelApi) : IMarvelRepository {
    override suspend fun getAllCharacters(offset: Int): List<Character>? {

        kotlin.runCatching { api.getAllCharacters(offset = offset.toString()).data.results.map { it.toCharacter() } }
            .onSuccess { return it }
            .onFailure {
                Log.i(
                    "ERROR",
                    "Error en HoroscopeRepositoryImpl::getPrediction => ${it.message}"
                )
            }

        return null
    }
}