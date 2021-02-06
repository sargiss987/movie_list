package com.example.movielist.domain.usecase

import com.example.movielist.data.model.PopularMovie
import com.example.movielist.domain.repository.PopularMovieRepository

class GetPopularMoviesUseCase(private val repository : PopularMovieRepository) {

    suspend fun execute() : List<PopularMovie>? = repository.getPopularMovies()

}