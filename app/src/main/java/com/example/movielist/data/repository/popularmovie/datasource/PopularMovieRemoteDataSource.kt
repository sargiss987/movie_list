package com.example.movielist.data.repository.popularmovie.datasource

import com.example.movielist.data.model.PopularMovieList
import retrofit2.Response

interface PopularMovieRemoteDataSource {

     suspend fun getPopularMovies() : Response<PopularMovieList>
}