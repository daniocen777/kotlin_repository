package com.danicode.marveluniverseclean.domain.use_cases

import android.util.Log
import com.danicode.marveluniverseclean.domain.repository.IMarvelRepository
import com.danicode.marveluniverseclean.util.Response
import com.danicode.marveluniverseclean.domain.model.Character
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: IMarvelRepository
) {
    suspend operator fun invoke(offset: Int) = repository.getAllCharacters(offset)
}