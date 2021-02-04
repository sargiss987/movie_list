package com.example.movielist.data.repository.upcomingmovie.datasourceimpl

import com.example.movielist.data.model.upcomingmovie.UpcomingMovie
import com.example.movielist.data.repository.upcomingmovie.datasource.UpcomingMovieCacheDataSource

class UpcomingMovieCacheDataSourceImpl() : UpcomingMovieCacheDataSource {

    private var upcomingMovies  = ArrayList<UpcomingMovie>()

    override suspend fun getUpcomingMoviesFromCache(): List<UpcomingMovie> {
        return  upcomingMovies
    }

    override suspend fun saveUpcomingMoviesToCache(movies: List<UpcomingMovie>) {
        upcomingMovies.clear()
        upcomingMovies = ArrayList(movies)
    }
}