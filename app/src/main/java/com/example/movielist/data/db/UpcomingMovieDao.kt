package com.example.movielist.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movielist.data.model.popularmovie.PopularMovie
import com.example.movielist.data.model.upcomingmovie.UpcomingMovie

@Dao
interface UpcomingMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUpcomingMovies(movies: List<UpcomingMovie>)

    @Query("DELETE FROM upcoming_movies")
    suspend fun deleteAllUpcomingMovies()

    @Query("SELECT * FROM upcoming_movies")
    suspend fun getUpcomingMovies(): List<UpcomingMovie>

}