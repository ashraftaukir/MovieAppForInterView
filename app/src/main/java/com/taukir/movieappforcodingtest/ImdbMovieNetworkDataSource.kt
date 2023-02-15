package com.taukir.movieappforcodingtest

import com.taukir.movieappforcodingtest.model.ImdbMovie
import com.taukir.movieappforcodingtest.model.ImdbMoviesResponse
import com.taukir.movieappforcodingtest.repository.ImdbMovieAPI
import retrofit2.Response
import java.io.IOException

class ImdbMovieNetworkDataSource {

    suspend fun fetchMovies(movieName: String): List<ImdbMovie>? {
        var response: Response<ImdbMoviesResponse>? = null
        var movies: List<ImdbMovie>? = null

        try {
            response = ImdbMovieAPI().getImdbMovies()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        response?.let {
            if (response.isSuccessful) {
                movies = response.body()?.imdbMovieList
            }
        }
        return movies
    }
}