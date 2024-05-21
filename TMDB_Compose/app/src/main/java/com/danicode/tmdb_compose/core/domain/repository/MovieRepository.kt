package com.danicode.tmdb_compose.core.domain.repository

import com.danicode.tmdb_compose.core.domain.model.Movie

interface MovieRepository {
    suspend fun getUpcomingMovies(): List<Movie>
}