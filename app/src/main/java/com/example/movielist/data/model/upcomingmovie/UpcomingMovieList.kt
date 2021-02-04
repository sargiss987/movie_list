package com.example.movielist.data.model.upcomingmovie

import com.google.gson.annotations.SerializedName

data class UpcomingMovieList(
    @SerializedName("results")
    val results: List<UpcomingMovie>,

    )