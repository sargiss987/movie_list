package com.example.movielist.data.repository.upcomingmovie.datasourceimpl

import com.example.movielist.data.api.TMDBService
import com.example.movielist.data.model.popularmovie.PopularMovieList
import com.example.movielist.data.model.upcomingmovie.UpcomingMovieList
import com.example.movielist.data.repository.popularmovie.datasource.PopularMovieRemoteDataSource
import com.example.movielist.data.repository.upcomingmovie.datasource.UpcomingMovieRemoteDataSource
import retrofit2.Response

class UpcomingMovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String): UpcomingMovieRemoteDataSource {

    override suspend fun getUpcomingMovies(): Response<UpcomingMovieList> {
        return tmdbService.getUpcomingMovies(apiKey)
    }


}