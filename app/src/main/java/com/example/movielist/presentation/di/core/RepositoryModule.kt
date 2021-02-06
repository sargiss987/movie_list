package com.example.movielist.presentation.di.core

import com.example.movielist.data.repository.PopularMovieRepositoryImpl
import com.example.movielist.data.repository.popularmovie.datasource.PopularMovieCacheDataSource
import com.example.movielist.data.repository.popularmovie.datasource.PopularMovieLocalDataSource
import com.example.movielist.data.repository.popularmovie.datasource.PopularMovieRemoteDataSource
import com.example.movielist.domain.repository.PopularMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providePopularMovieRepository(
        popularMovieRemoteDataSource: PopularMovieRemoteDataSource,
        popularMovieLocalDataSource: PopularMovieLocalDataSource,
        popularMovieCacheDataSource: PopularMovieCacheDataSource
    ) : PopularMovieRepository {
        return PopularMovieRepositoryImpl(
           popularMovieRemoteDataSource,
           popularMovieLocalDataSource,
           popularMovieCacheDataSource)
    }


}