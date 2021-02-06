package com.example.movielist.data.repository.popularmovie.datasource

import com.example.movielist.data.model.PopularMovie

interface PopularMovieLocalDataSource {

  suspend fun savePopularMoviesToDB(movies : List<PopularMovie>)
  suspend fun getPopularMoviesFromDB(): List<PopularMovie>
  suspend fun clearAll()
}