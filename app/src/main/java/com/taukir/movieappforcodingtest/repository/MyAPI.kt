package com.taukir.movieappforcodingtest.repository

import com.taukir.movieappforcodingtest.model.MoviesResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyAPI {

    @GET("http://www.omdbapi.com/?apikey=899f27bf")
    suspend fun getMovies(): Response<MoviesResponse>

    companion object {
        operator fun invoke(): MyAPI {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://www.omdbapi.com/")
                .build()
                .create(MyAPI::class.java)
        }
    }
}