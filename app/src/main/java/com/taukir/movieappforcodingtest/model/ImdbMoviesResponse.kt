package com.taukir.movieappforcodingtest.model

import com.google.gson.annotations.SerializedName

data class ImdbMoviesResponse(
    @SerializedName("Search")
    val imdbMovieList: List<ImdbMovie>,
    val totalResults: String,
    val Response: String
)
