package com.example.movielist.data.repository.upcomingmovie

import android.util.Log
import com.example.movielist.data.model.popularmovie.PopularMovie
import com.example.movielist.data.model.upcomingmovie.UpcomingMovie
import com.example.movielist.data.repository.upcomingmovie.datasource.UpcomingMovieCacheDataSource
import com.example.movielist.data.repository.upcomingmovie.datasource.UpcomingMovieLocalDataSource
import com.example.movielist.data.repository.upcomingmovie.datasource.UpcomingMovieRemoteDataSource
import com.example.movielist.domain.repository.UpcomingMovieRepository
import java.lang.Exception

class UpcomingMovieRepositoryImpl(
    private val upcomingMovieRemoteDataSource: UpcomingMovieRemoteDataSource,
    private val upcomingMovieLocalDataSource: UpcomingMovieLocalDataSource,
    private val upcomingMovieCacheDataSource: UpcomingMovieCacheDataSource
): UpcomingMovieRepository {

    override suspend fun getUpcomingMovies(): List<UpcomingMovie> {
        return  getUpcomingMoviesFromCache()
    }

    override suspend fun updateUpcomingMovies(): List<UpcomingMovie> {
        val newUpcomingMovies = getUpcomingMoviesFromAPI()
        upcomingMovieLocalDataSource.clearAll()
        upcomingMovieLocalDataSource.saveUpcomingMoviesToDB(newUpcomingMovies)
        upcomingMovieCacheDataSource.saveUpcomingMoviesToCache(newUpcomingMovies)

        return newUpcomingMovies
    }

    private suspend fun getUpcomingMoviesFromAPI(): List<UpcomingMovie>{
        lateinit var upcomingMovie: List<UpcomingMovie>
        try {
            val response = upcomingMovieRemoteDataSource.getUpcomingMovies()
            val body = response.body()
            if (body != null){
                upcomingMovie = body.results
            }

        }catch (ex : Exception){
            Log.i("myTag", ex.message.toString())
        }

        return upcomingMovie
    }

    private suspend fun getUpcomingMoviesFromDB(): List<UpcomingMovie>{
        lateinit var upcomingMovie: List<UpcomingMovie>

        try {
            upcomingMovie = upcomingMovieLocalDataSource.getUpcomingMoviesFromDB()
        }catch (ex : Exception){
            Log.i("myTag", ex.message.toString())
        }


        if (upcomingMovie.isNotEmpty()){
            return upcomingMovie
        }else{
            upcomingMovie = getUpcomingMoviesFromAPI()
            upcomingMovieLocalDataSource.saveUpcomingMoviesToDB(upcomingMovie)
        }

        return upcomingMovie
    }

    suspend fun getUpcomingMoviesFromCache(): List<UpcomingMovie>{
        lateinit var upcomingMovie: List<UpcomingMovie>
        try {
            upcomingMovie = upcomingMovieCacheDataSource.getUpcomingMoviesFromCache()
        }catch (ex : Exception){
            Log.i("myTag", ex.message.toString())
        }

        if (upcomingMovie.isNotEmpty()){
            return upcomingMovie
        }else{
            upcomingMovie = getUpcomingMoviesFromDB()
            upcomingMovieCacheDataSource.saveUpcomingMoviesToCache(upcomingMovie)
        }

        return upcomingMovie
    }
}