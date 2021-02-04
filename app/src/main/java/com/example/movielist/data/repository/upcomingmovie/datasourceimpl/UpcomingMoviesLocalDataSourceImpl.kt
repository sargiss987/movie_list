package com.example.movielist.data.repository.upcomingmovie.datasourceimpl

import com.example.movielist.data.db.UpcomingMovieDao
import com.example.movielist.data.model.upcomingmovie.UpcomingMovie
import com.example.movielist.data.repository.upcomingmovie.datasource.UpcomingMovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UpcomingMoviesLocalDataSourceImpl
    (private  val upcomingMovieDao: UpcomingMovieDao) : UpcomingMovieLocalDataSource {

    override suspend fun saveUpcomingMoviesToDB(movies: List<UpcomingMovie>) {
        CoroutineScope(Dispatchers.IO).launch {
            upcomingMovieDao.saveUpcomingMovies(movies)
        }

    }

    override suspend fun getUpcomingMoviesFromDB(): List<UpcomingMovie> {
       return upcomingMovieDao.getUpcomingMovies()
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            upcomingMovieDao.deleteAllUpcomingMovies()
        }

    }
}