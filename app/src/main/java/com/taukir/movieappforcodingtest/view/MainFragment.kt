package com.taukir.movieappforcodingtest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.taukir.movieappforcodingtest.R
import com.taukir.movieappforcodingtest.adapter.MovieAdapter
import com.taukir.movieappforcodingtest.adapter.MovieListener
import com.taukir.movieappforcodingtest.databinding.FragmentMainBinding
import com.taukir.movieappforcodingtest.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentMainBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        val movieViewModel: MovieViewModel by viewModels()

        val movieAdapter = MovieAdapter(MovieListener { movie ->
            movieViewModel.onMovieClicked(movie)
        }
        )
        binding.movieRecyclerview.adapter = movieAdapter
        binding.viewmodel = movieViewModel

        movieViewModel.navigateToMovieDetail.observe(viewLifecycleOwner) { movie ->
            movie?.let {
                this.findNavController().navigate(
                    MainFragmentDirections
                        .actionMainFragmentToDetailFragment(movie)
                )
                movieViewModel.onMovieDetailNavigated()
            }
        }

        movieViewModel.movies.observe(viewLifecycleOwner) {
            movieAdapter.differ.submitList(it)
            binding.groupLoading.visibility = View.GONE
        }


        return binding.root
    }
}