package com.example.movielist.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movielist.data.model.popularmovie.PopularMovie
import com.example.movielist.data.model.upcomingmovie.UpcomingMovie

@Database(entities = [PopularMovie::class,UpcomingMovie::class],version = 1,exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun upcomingMovieMovieDao(): UpcomingMovieDao
}