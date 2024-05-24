package com.danicode.firebase.di

import com.danicode.firebase.data.remote.FirebaseAuthRepositoryImpl
import com.danicode.firebase.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    // Cada vez que se pida la interfaz AuthRepository, devolvera la implementacion
    @Binds
    abstract fun bindAuthRepository(authRepository: FirebaseAuthRepositoryImpl): AuthRepository
}