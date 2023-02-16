package com.taukir.movieappforcodingtest.repository.network

import com.taukir.movieappforcodingtest.model.Movie
import com.taukir.movieappforcodingtest.model.MoviesResponse
import com.taukir.movieappforcodingtest.repository.MyAPI
import retrofit2.Response
import java.io.IOException

class MovieNetworkDataSource {

    suspend fun fetchMovies(movieName: String): List<Movie>? {
        var response: Response<MoviesResponse>? = null
        var movies: List<Movie>? = null

        try {
            response = MyAPI().getMovies()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        response?.let {
            if (response.isSuccessful) {
                movies = response.body()?.movieList
            }
        }
        return movies
    }
}