package com.taukir.movieappforcodingtest

import com.taukir.movieappforcodingtest.repository.ImdbMovieDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class ImdbMovieRepository(

    private val imdbMovieDatabase: ImdbMovieDatabase


) {

    val movies = imdbMovieDatabase.movieDatabaseDao.getAllImdbMovies()

    suspend fun refreshMovies(movieName: String) {
        withContext(Dispatchers.IO) {
            val movies = async { ImdbMovieNetworkDataSource().fetchMovies(movieName) }
            movies.await()?.let { imdbMovieDatabase.movieDatabaseDao.insert(it) }
        }
    }
}