package com.example.movielist.presentation.popularMovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movielist.domain.usecase.GetPopularMoviesUseCase
import com.example.movielist.domain.usecase.UpdatePopularMoviesUseCase

class PopularMovieViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val updatePopularMoviesUseCase: UpdatePopularMoviesUseCase
) : ViewModel() {

      fun getPopularMovies() = liveData {
          val result = getPopularMoviesUseCase.execute()
          emit(result)
      }

    fun updatePopularMovies() = liveData {
        val result = updatePopularMoviesUseCase.execute()
        emit(result)
    }

}