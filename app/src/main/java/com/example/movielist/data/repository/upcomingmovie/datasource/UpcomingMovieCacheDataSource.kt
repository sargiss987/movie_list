package com.example.movielist.data.repository.upcomingmovie.datasource


import com.example.movielist.data.model.upcomingmovie.UpcomingMovie

interface UpcomingMovieCacheDataSource {

    suspend fun getUpcomingMoviesFromCache(): List<UpcomingMovie>
    suspend fun saveUpcomingMoviesToCache(movies: List<UpcomingMovie>)
}