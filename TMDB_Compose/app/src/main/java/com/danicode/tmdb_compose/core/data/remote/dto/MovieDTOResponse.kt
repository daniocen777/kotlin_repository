package com.danicode.tmdb_compose.core.data.remote.dto

data class MovieDTOResponse(
    val dates: Dates,
    val page: Int,
    val results: List<MovieResult>,
    val total_pages: Int,
    val total_results: Int
)