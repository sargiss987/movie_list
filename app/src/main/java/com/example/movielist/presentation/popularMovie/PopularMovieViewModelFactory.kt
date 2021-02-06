package com.example.movielist.presentation.popularMovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movielist.domain.usecase.GetPopularMoviesUseCase
import com.example.movielist.domain.usecase.UpdatePopularMoviesUseCase

class PopularMovieViewModelFactory(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val updatePopularMoviesUseCase: UpdatePopularMoviesUseCase
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return PopularMovieViewModel(getPopularMoviesUseCase,updatePopularMoviesUseCase) as T
    }
}