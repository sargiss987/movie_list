package com.example.movielist.data.repository.popularmovie

import android.util.Log
import com.example.movielist.data.model.popularmovie.PopularMovie
import com.example.movielist.data.repository.popularmovie.datasource.PopularMovieCacheDataSource
import com.example.movielist.data.repository.popularmovie.datasource.PopularMovieLocalDataSource
import com.example.movielist.data.repository.popularmovie.datasource.PopularMovieRemoteDataSource
import com.example.movielist.domain.repository.PopularMovieRepository
import java.lang.Exception

class PopularMovieRepositoryImpl(
    private val popularMovieRemoteDataSource: PopularMovieRemoteDataSource,
    private val popularMovieLocalDataSource: PopularMovieLocalDataSource,
    private val popularMovieCacheDataSource: PopularMovieCacheDataSource
): PopularMovieRepository {

    override suspend fun getPopularMovies(): List<PopularMovie> {
        return getPopularMoviesFromCache()
    }

    override suspend fun updatePopularMovies(): List<PopularMovie> {
        val newPopularMovieList: List<PopularMovie> = getPopularMoviesFromAPI()
        popularMovieLocalDataSource.clearAll()
        popularMovieLocalDataSource.savePopularMoviesToDB(newPopularMovieList)
        popularMovieCacheDataSource.savePopularMoviesToCache(newPopularMovieList)

        return newPopularMovieList
    }

   private suspend fun getPopularMoviesFromAPI(): List<PopularMovie>{
       lateinit var popularMovie: List<PopularMovie>
       try {
           val response = popularMovieRemoteDataSource.getPopularMovies()
           val body = response.body()
           if (body != null){
               popularMovie = body.results
           }

       }catch (ex : Exception){
           Log.i("myTag", ex.message.toString())
       }

       return popularMovie
   }

    private suspend fun getPopularMoviesFromDB(): List<PopularMovie>{
        lateinit var popularMovie: List<PopularMovie>

        try {
            popularMovie = popularMovieLocalDataSource.getPopularMoviesFromDB()
        }catch (ex : Exception){
            Log.i("myTag", ex.message.toString())
        }


        if (popularMovie.isNotEmpty()){
            return popularMovie
        }else{
            popularMovie = getPopularMoviesFromAPI()
            popularMovieLocalDataSource.savePopularMoviesToDB(popularMovie)
        }

        return popularMovie
    }

    suspend fun getPopularMoviesFromCache(): List<PopularMovie>{
        lateinit var popularMovie: List<PopularMovie>
        try {
            popularMovie = popularMovieCacheDataSource.getPopularMoviesFromCache()
        }catch (ex : Exception){
            Log.i("myTag", ex.message.toString())
        }

        if (popularMovie.isNotEmpty()){
            return popularMovie
        }else{
            popularMovie = getPopularMoviesFromDB()
            popularMovieCacheDataSource.savePopularMoviesToCache(popularMovie)
        }

        return popularMovie
    }
}