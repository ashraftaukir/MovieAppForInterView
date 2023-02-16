package com.taukir.movieappforcodingtest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taukir.movieappforcodingtest.repository.MovieRepository
import com.taukir.movieappforcodingtest.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel  @Inject constructor(

    movieRepository: MovieRepository

):ViewModel() {


    val movies = movieRepository.movies


    init {
        viewModelScope.launch {
            movieRepository.refreshMovies("batman")
        }
    }



    //Navigate to detail
    private val _navigateToMovieDetail = MutableLiveData<Movie>()
    val navigateToMovieDetail
        get() = _navigateToMovieDetail

    fun onMovieClicked(movie: Movie) {
        _navigateToMovieDetail.value = movie
    }

    fun onMovieDetailNavigated() {
        _navigateToMovieDetail.value = null
    }

}