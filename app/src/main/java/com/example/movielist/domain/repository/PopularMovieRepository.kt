package com.example.movielist.domain.repository

import com.example.movielist.data.model.PopularMovie

interface PopularMovieRepository {

    suspend fun getPopularMovies(): List<PopularMovie>?
    suspend fun updatePopularMovies(): List<PopularMovie>?
}