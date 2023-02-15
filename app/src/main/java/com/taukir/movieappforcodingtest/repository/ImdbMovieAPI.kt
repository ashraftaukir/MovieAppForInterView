package com.taukir.movieappforcodingtest.repository

import com.taukir.movieappforcodingtest.model.ImdbMoviesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ImdbMovieAPI {

    @GET("http://www.omdbapi.com/?apikey=899f27bf")
    suspend fun getImdbMovies(): Response<ImdbMoviesResponse>

    companion object {
        operator fun invoke(): ImdbMovieAPI {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.omdbapi.com/")
                .build()
                .create(ImdbMovieAPI::class.java)
        }
    }
}