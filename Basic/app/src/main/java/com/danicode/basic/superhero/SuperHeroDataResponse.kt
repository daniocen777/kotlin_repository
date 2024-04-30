package com.danicode.basic.superhero

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(
    val totalResults: String,
    @SerializedName("Response") val response: String,
    @SerializedName("Search") val heroes: List<HeroItemResponse>
)

data class HeroItemResponse(
    @SerializedName("Title")
    val title: String,

    @SerializedName("Year")
    val year: String,

    val imdbID: String,

    @SerializedName("Type")
    val type: String,

    @SerializedName("Poster")
    val poster: String
)

// Si existe otro un dato dentro de otro objeto, se crea otro data class