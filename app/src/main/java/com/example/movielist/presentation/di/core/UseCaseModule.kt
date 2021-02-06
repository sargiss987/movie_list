package com.example.movielist.presentation.di.core

import com.example.movielist.domain.repository.PopularMovieRepository
import com.example.movielist.domain.usecase.GetPopularMoviesUseCase
import com.example.movielist.domain.usecase.UpdatePopularMoviesUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

   @Provides
   fun provideGetPopularMovieUseCase(popularMovieRepository : PopularMovieRepository): GetPopularMoviesUseCase{
       return GetPopularMoviesUseCase(popularMovieRepository)
   }

    @Provides
    fun provideUpdatePopularMovieUseCase(popularMovieRepository : PopularMovieRepository): UpdatePopularMoviesUseCase {
        return UpdatePopularMoviesUseCase(popularMovieRepository)
    }


}