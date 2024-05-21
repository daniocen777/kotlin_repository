package com.danicode.tmdb_compose.core.data.mapper

import com.danicode.tmdb_compose.core.data.remote.MovieApi
import com.danicode.tmdb_compose.core.data.remote.dto.MovieResult
import com.danicode.tmdb_compose.core.domain.model.Movie

fun MovieResult.toDomain(): Movie {
    return Movie(
        description = this.overview,
        title = this.title,
        releaseYear = this.release_date.substring(0, 4).toInt(),
        language = this.original_language,
        rating = this.vote_average,
        poster = MovieApi.IMAGE_URL + this.poster_path,
        genres = this.genre_ids
    )
}