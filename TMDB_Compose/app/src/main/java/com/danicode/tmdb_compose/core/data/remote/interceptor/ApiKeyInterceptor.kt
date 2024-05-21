package com.danicode.tmdb_compose.core.data.remote.interceptor

import com.danicode.tmdb_compose.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

// Colocar el api_key a las llamadas a la api de tmfb
class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder().addQueryParameter(
            "api_key", BuildConfig.API_KEY
        ).build()

        val newRequest = request.newBuilder().url(url).build()
        return chain.proceed(newRequest)
    }
}