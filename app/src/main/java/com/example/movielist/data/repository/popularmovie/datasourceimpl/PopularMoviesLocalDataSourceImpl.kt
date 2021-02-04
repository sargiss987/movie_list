package com.example.movielist.data.repository.popularmovie.datasourceimpl

import com.example.movielist.data.db.PopularMovieDao
import com.example.movielist.data.model.popularmovie.PopularMovie
import com.example.movielist.data.repository.popularmovie.datasource.PopularMovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class PopularMoviesLocalDataSourceImpl
    (private  val popularMovieDao: PopularMovieDao) : PopularMovieLocalDataSource{

    override suspend fun savePopularMoviesToDB(movies: List<PopularMovie>) {
        CoroutineScope(Dispatchers.IO).launch {
            popularMovieDao.savePopularMovies(movies)
        }

    }

    override suspend fun getPopularMoviesFromDB(): List<PopularMovie> {
       return popularMovieDao.getPopularMovies()
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            popularMovieDao.deleteAllPopularMovies()
        }

    }
}