package com.danicode.tmdb_compose.core.data.repository

import com.danicode.tmdb_compose.core.data.mapper.toDomain
import com.danicode.tmdb_compose.core.data.remote.MovieApi
import com.danicode.tmdb_compose.core.domain.model.Movie
import com.danicode.tmdb_compose.core.domain.repository.MovieRepository

class MovieRepositoryImpl(val api: MovieApi) : MovieRepository {
    override suspend fun getUpcomingMovies(): List<Movie> {
        return api.getUpcomingMovies().results.map { it.toDomain() }
    }
}