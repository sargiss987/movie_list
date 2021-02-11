package com.example.movielist.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movielist.data.model.PopularMovie

@Database(entities = [PopularMovie::class],version = 1,exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun popularMovieDao(): PopularMovieDao



}