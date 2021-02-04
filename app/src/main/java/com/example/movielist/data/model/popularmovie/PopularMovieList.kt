package com.example.movielist.data.model.popularmovie

import com.google.gson.annotations.SerializedName

data class PopularMovieList(
    @SerializedName("results")
    val results: List<PopularMovie>,

    )