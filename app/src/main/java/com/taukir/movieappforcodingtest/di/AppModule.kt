package com.taukir.movieappforcodingtest.di

import android.content.Context
import com.taukir.movieappforcodingtest.repository.db.MovieDatabase
import com.taukir.movieappforcodingtest.repository.network.MovieNetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = MovieDatabase.getInstance(context)

    @Singleton
    @Provides
    fun provideMovieNetworkDataSource() = MovieNetworkDataSource()
}