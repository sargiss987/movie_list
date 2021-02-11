package com.example.movielist.data.repository.poularmovie

import com.example.movielist.data.model.PopularMovie
import com.example.movielist.domain.repository.PopularMovieRepository

class FakePopularMovieRepository: PopularMovieRepository {
    private val movies = mutableListOf<PopularMovie>()

    init {
        movies.add(PopularMovie(1,"overview1","posterPath1","title1"))
        movies.add(PopularMovie(2,"overview2","posterPath2","title2"))

    }

    override suspend fun getPopularMovies(): List<PopularMovie>{
        return movies
    }

    override suspend fun updatePopularMovies(): List<PopularMovie> {
        movies.clear()
        movies.add(PopularMovie(3,"overview3","posterPath3","title3"))
        movies.add(PopularMovie(4,"overview4","posterPath4","title4"))
        return movies

    }
}