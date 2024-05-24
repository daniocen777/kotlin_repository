package com.danicode.firebase.domain.usecase

import android.util.Log
import com.danicode.firebase.domain.repository.AuthRepository
import com.danicode.firebase.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class FirebaseSignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading)
        val isSignUpSuccessfully = authRepository.signup(email, password)
        Log.i("FirebaseSignUpUseCase", isSignUpSuccessfully.toString())
        if (isSignUpSuccessfully) {
            emit(Resource.Success(true))
        } else {
            emit(Resource.Error("Sign up error"))
        }
    }
}