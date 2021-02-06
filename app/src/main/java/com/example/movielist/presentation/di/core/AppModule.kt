package com.example.movielist.presentation.di.core

import android.content.Context
import com.example.movielist.presentation.di.popualrmovie.PopularMovieSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(subcomponents = [PopularMovieSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}