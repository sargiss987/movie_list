package com.example.movielist.presentation.di.popualrmovie

import com.example.movielist.domain.usecase.GetPopularMoviesUseCase
import com.example.movielist.domain.usecase.UpdatePopularMoviesUseCase
import com.example.movielist.presentation.popularMovie.PopularMovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PopularMovieModule {

    @PopularMovieScope
    @Provides
    fun providePopularMovieViewModelFactory(
        getPopularMoviesUseCase: GetPopularMoviesUseCase,
        updatePopularMoviesUseCase: UpdatePopularMoviesUseCase
    ): PopularMovieViewModelFactory {
        return PopularMovieViewModelFactory(
            getPopularMoviesUseCase,updatePopularMoviesUseCase)
    }
}