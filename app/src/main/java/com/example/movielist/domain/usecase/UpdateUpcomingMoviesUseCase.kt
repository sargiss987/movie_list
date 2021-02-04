package com.example.movielist.domain.usecase


import com.example.movielist.data.model.upcomingmovie.UpcomingMovie
import com.example.movielist.domain.repository.UpcomingMovieRepository

class UpdateUpcomingMoviesUseCase(private val repository : UpcomingMovieRepository) {

    suspend fun execute(): List<UpcomingMovie>? = repository.updateUpcomingMovies()
}