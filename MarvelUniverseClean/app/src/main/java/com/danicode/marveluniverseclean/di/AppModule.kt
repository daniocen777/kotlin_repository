package com.danicode.marveluniverseclean.di

import android.provider.SyncStateContract.Constants.*
import com.danicode.marveluniverseclean.data.data_source.IMarvelApi
import com.danicode.marveluniverseclean.data.repository.MarvelRepositoryImpl
import com.danicode.marveluniverseclean.domain.repository.IMarvelRepository
import com.danicode.marveluniverseclean.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMarvelApi(): IMarvelApi {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IMarvelApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMarvelRepository(api: IMarvelApi): IMarvelRepository {
        return MarvelRepositoryImpl(api)
    }
}