package com.example.movielist.presentation

import android.app.Application
import com.example.movielist.BuildConfig
import com.example.movielist.presentation.di.Injector
import com.example.movielist.presentation.di.core.*
import com.example.movielist.presentation.di.popualrmovie.PopularMovieSubComponent


class App: Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createPopularMovieSubComponent(): PopularMovieSubComponent {
        return appComponent.popularMovieSubComponent().create()
    }


}