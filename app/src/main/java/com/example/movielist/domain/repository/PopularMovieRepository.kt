package com.example.movielist.domain.repository

import com.example.movielist.data.model.popularmovie.PopularMovie

interface PopularMovieRepository {

    suspend fun getPopularMovies(): List<PopularMovie>?
    suspend fun updatePopularMovies(): List<PopularMovie>?
}