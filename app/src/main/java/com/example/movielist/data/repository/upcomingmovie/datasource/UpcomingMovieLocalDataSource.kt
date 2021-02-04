package com.example.movielist.data.repository.upcomingmovie.datasource


import com.example.movielist.data.model.upcomingmovie.UpcomingMovie

interface UpcomingMovieLocalDataSource {

  suspend fun saveUpcomingMoviesToDB(movies : List<UpcomingMovie>)
  suspend fun getUpcomingMoviesFromDB(): List<UpcomingMovie>
  suspend fun clearAll()
}