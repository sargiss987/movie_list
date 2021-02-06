package com.example.movielist.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movielist.data.model.PopularMovie

@Dao
interface PopularMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePopularMovies(movies: List<PopularMovie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllPopularMovies()

    @Query("SELECT * FROM popular_movies")
    suspend fun getPopularMovies(): List<PopularMovie>

}