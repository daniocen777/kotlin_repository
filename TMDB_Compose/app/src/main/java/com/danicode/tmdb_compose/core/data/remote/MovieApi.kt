package com.danicode.tmdb_compose.core.data.remote

import com.danicode.tmdb_compose.core.data.remote.dto.MovieDTOResponse
import retrofit2.http.GET

interface MovieApi {
    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/original/"
    }

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(): MovieDTOResponse
}