package com.example.movielist.data.repository.popularmovie.datasourceimpl

import com.example.movielist.data.model.popularmovie.PopularMovie
import com.example.movielist.data.repository.popularmovie.datasource.PopularMovieCacheDataSource

class PopularMovieCacheDataSourceImpl() : PopularMovieCacheDataSource {

    private var popularMovies  = ArrayList<PopularMovie>()

    override suspend fun getPopularMoviesFromCache(): List<PopularMovie> {
        return  popularMovies
    }

    override suspend fun savePopularMoviesToCache(movies: List<PopularMovie>) {
        popularMovies.clear()
        popularMovies = ArrayList(movies)
    }
}