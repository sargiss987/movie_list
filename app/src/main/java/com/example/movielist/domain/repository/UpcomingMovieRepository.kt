package com.example.movielist.domain.repository


import com.example.movielist.data.model.upcomingmovie.UpcomingMovie

interface UpcomingMovieRepository {

    suspend fun getUpcomingMovies(): List<UpcomingMovie>?
    suspend fun updateUpcomingMovies(): List<UpcomingMovie>?
}