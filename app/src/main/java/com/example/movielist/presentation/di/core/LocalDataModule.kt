package com.example.movielist.presentation.di.core

import com.example.movielist.data.db.PopularMovieDao
import com.example.movielist.data.repository.popularmovie.datasource.PopularMovieLocalDataSource
import com.example.movielist.data.repository.popularmovie.datasourceimpl.PopularMoviesLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providePopularMovieLocalDataSource(popularMovieDao: PopularMovieDao): PopularMovieLocalDataSource {
        return PopularMoviesLocalDataSourceImpl(popularMovieDao)
    }


}