package com.danicode.horocopoapp.data.network

import com.danicode.horocopoapp.data.repository.HoroscopeRepositoryImpl
import com.danicode.horocopoapp.domain.repository.IHoroscopeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

// Poder injectar objetos donde se quiera (@Provides)
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://newastro.vercel.app")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit): IHoroscopeApiService {
        return retrofit.create(IHoroscopeApiService::class.java)
    }

    // dominio
    @Provides
    fun provideHoroscopeRepository(apiService: IHoroscopeApiService): IHoroscopeRepository {
        return HoroscopeRepositoryImpl(apiService)
    }
}