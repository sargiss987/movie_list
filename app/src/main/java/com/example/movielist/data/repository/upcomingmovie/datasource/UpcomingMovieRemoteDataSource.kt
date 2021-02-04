package com.example.movielist.data.repository.upcomingmovie.datasource

import com.example.movielist.data.model.upcomingmovie.UpcomingMovieList
import retrofit2.Response

interface UpcomingMovieRemoteDataSource {

     suspend fun getUpcomingMovies() : Response<UpcomingMovieList>
}