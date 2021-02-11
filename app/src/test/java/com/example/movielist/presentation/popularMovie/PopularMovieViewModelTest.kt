package com.example.movielist.presentation.popularMovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.movielist.data.model.PopularMovie
import com.example.movielist.data.repository.poularmovie.FakePopularMovieRepository
import com.example.movielist.domain.usecase.GetPopularMoviesUseCase
import com.example.movielist.domain.usecase.UpdatePopularMoviesUseCase
import com.example.movielist.getOrAwaitValue
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest= Config.NONE)
class PopularMovieViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieViewModel: PopularMovieViewModel

    @Before
    fun setUp() {
       val fakePopularMovieRepository = FakePopularMovieRepository()
       val getPopularMoviesUseCase = GetPopularMoviesUseCase(fakePopularMovieRepository)
       val updatePopularMoviesUseCase = UpdatePopularMoviesUseCase(fakePopularMovieRepository)
        movieViewModel = PopularMovieViewModel(getPopularMoviesUseCase,updatePopularMoviesUseCase)
    }

    @Test
    fun getMovies_returnCurrentList(){
        val movies = mutableListOf<PopularMovie>()
        movies.add(PopularMovie(1,"overview1","posterPath1","title1"))
        movies.add(PopularMovie(2,"overview2","posterPath2","title2"))

        val currentMovies = movieViewModel.getPopularMovies().getOrAwaitValue()
        Truth.assertThat(currentMovies).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnUpdatedList(){
        val movies = mutableListOf<PopularMovie>()
        movies.add(PopularMovie(3,"overview3","posterPath3","title3"))
        movies.add(PopularMovie(4,"overview4","posterPath4","title4"))

        val updatedMovies = movieViewModel.updatePopularMovies().getOrAwaitValue()
        Truth.assertThat(updatedMovies).isEqualTo(movies)
    }
}