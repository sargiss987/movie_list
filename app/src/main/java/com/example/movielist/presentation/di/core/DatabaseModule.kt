package com.example.movielist.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.movielist.data.db.PopularMovieDao
import com.example.movielist.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideTMBDDataBase(context: Context): TMDBDatabase{
        return Room.databaseBuilder(context, TMDBDatabase::class.java,"tmbdclient")
            .build()
    }

    @Singleton
    @Provides
    fun providePopularMovieDao(tmdbDatabase: TMDBDatabase): PopularMovieDao{
        return tmdbDatabase.popularMovieDao()
    }

}