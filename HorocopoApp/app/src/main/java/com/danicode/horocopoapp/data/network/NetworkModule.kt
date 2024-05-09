package com.danicode.horocopoapp.data.network

import com.danicode.horocopoapp.core.interceptors.AuthInterceptor
import com.danicode.horocopoapp.data.repository.HoroscopeRepositoryImpl
import com.danicode.horocopoapp.domain.repository.IHoroscopeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

// Poder injectar objetos donde se quiera (@Provides)
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Los interceptor (okHttpClient) estan dentro de Retrofit

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://newastro.vercel.app")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Interceptor
    @Provides
    @Singleton
    fun provideOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(authInterceptor)
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