package com.example.movielist.data.repository.popularmovie.datasourceimpl

import com.example.movielist.data.api.TMDBService
import com.example.movielist.data.model.PopularMovieList
import com.example.movielist.data.repository.popularmovie.datasource.PopularMovieRemoteDataSource
import retrofit2.Response

class PopularMovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String): PopularMovieRemoteDataSource {

    override suspend fun getPopularMovies(): Response<PopularMovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}