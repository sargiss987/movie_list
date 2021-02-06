package com.example.movielist.data.repository.popularmovie.datasource

import com.example.movielist.data.model.PopularMovie

interface PopularMovieCacheDataSource {

    suspend fun getPopularMoviesFromCache(): List<PopularMovie>
    suspend fun savePopularMoviesToCache(movies: List<PopularMovie>)
}