package com.taukir.movieappforcodingtest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taukir.movieappforcodingtest.ImdbMovieRepository
import com.taukir.movieappforcodingtest.model.ImdbMovie
import kotlinx.coroutines.launch

class ImdbMovieViewModel(

    imdbMovieRepository: ImdbMovieRepository

):ViewModel() {


    val movies = imdbMovieRepository.movies


    init {
        viewModelScope.launch {
            imdbMovieRepository.refreshMovies("batman")
        }
    }



    //Navigate to detail
    private val _navigateToMovieDetail = MutableLiveData<ImdbMovie>()
    val navigateToMovieDetail
        get() = _navigateToMovieDetail

    fun onMovieClicked(movie: ImdbMovie) {
        _navigateToMovieDetail.value = movie
    }

    fun onMovieDetailNavigated() {
        _navigateToMovieDetail.value = null
    }

}