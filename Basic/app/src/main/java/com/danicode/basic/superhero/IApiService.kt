package com.danicode.basic.superhero


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {

    // suspend (corrutina) => como el async en javascript o dart
    @GET("/")
    suspend fun getSuperHeroes(
        @Query("s") s: String,
        @Query("type") type: String = "movie",
        @Query("page") page: String = "1",
        @Query("r") r: String = "json",
        @Query("apikey") apikey: String = "83c53b2f"
    ): Response<SuperHeroDataResponse>
}