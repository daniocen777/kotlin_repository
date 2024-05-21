package com.danicode.tmdb_compose.core.di

import com.danicode.tmdb_compose.core.data.remote.MovieApi
import com.danicode.tmdb_compose.core.data.remote.interceptor.ApiKeyInterceptor
import com.danicode.tmdb_compose.core.data.repository.MovieRepositoryImpl
import com.danicode.tmdb_compose.core.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CoreModule {
    @Provides
    @Singleton
    fun provideApi(): MovieApi {
        // ApiKeyInterceptor => Agregar api_key en cada llamada
        val client = OkHttpClient
            .Builder()
            .addInterceptor(ApiKeyInterceptor())
            .build()

        return Retrofit
            .Builder()
            .baseUrl(MovieApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideRepository(api: MovieApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }
}