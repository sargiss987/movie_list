package com.example.movielist.data.model

import com.example.movielist.data.model.PopularMovie
import com.google.gson.annotations.SerializedName

data class PopularMovieList(
    @SerializedName("results")
    val results: List<PopularMovie>,

    )