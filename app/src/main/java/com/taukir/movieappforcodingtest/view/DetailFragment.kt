package com.taukir.movieappforcodingtest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.taukir.movieappforcodingtest.R
import com.taukir.movieappforcodingtest.databinding.FragmentDetailBinding

class DetailFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        val args: DetailFragmentArgs by navArgs()
        val movie = args.movie
        binding.movie = movie
        return binding.root
    }
}