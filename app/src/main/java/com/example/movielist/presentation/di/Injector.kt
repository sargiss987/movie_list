package com.example.movielist.presentation.di

import com.example.movielist.presentation.di.popualrmovie.PopularMovieSubComponent

interface Injector {

    fun createPopularMovieSubComponent() : PopularMovieSubComponent

}