package com.example.movielist.data.api

import com.example.movielist.data.model.PopularMovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")apiKey: String) :
            Response<PopularMovieList>


}