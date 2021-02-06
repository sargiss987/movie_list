package com.example.movielist.presentation.di.core

import com.example.movielist.data.repository.popularmovie.datasource.PopularMovieCacheDataSource
import com.example.movielist.data.repository.popularmovie.datasourceimpl.PopularMovieCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providePopularMovieCacheDataSource(): PopularMovieCacheDataSource {
        return PopularMovieCacheDataSourceImpl()
    }


}