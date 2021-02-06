package com.example.movielist.presentation.di.popualrmovie


import com.example.movielist.presentation.MainActivity
import dagger.Subcomponent

@PopularMovieScope
@Subcomponent(modules = [PopularMovieModule::class])
interface PopularMovieSubComponent {

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): PopularMovieSubComponent
    }
}