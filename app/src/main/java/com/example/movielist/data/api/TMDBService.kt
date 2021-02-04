package com.example.movielist.data.api

import com.example.movielist.data.model.popularmovie.PopularMovieList
import com.example.movielist.data.model.upcomingmovie.UpcomingMovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key")apiKey: String) :
            Response<PopularMovieList>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("api_key")apiKey: String) :
            Response<UpcomingMovieList>
}