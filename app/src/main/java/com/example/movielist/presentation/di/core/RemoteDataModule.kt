package com.example.movielist.presentation.di.core

import com.example.movielist.data.api.TMDBService
import com.example.movielist.data.repository.popularmovie.datasource.PopularMovieRemoteDataSource
import com.example.movielist.data.repository.popularmovie.datasourceimpl.PopularMovieRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun providePopularMovieRemoteDataSource(tmdbService: TMDBService): PopularMovieRemoteDataSource{
        return PopularMovieRemoteDataSourceImpl(
            tmdbService,
            apiKey
        )
    }

}