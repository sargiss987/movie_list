package com.example.movielist.domain.usecase

import com.example.movielist.data.model.popularmovie.PopularMovie
import com.example.movielist.domain.repository.PopularMovieRepository

class UpdatePopularMoviesUseCase(private val repository : PopularMovieRepository) {

    suspend fun execute(): List<PopularMovie>? = repository.updatePopularMovies()
}