package com.taukir.movieappforcodingtest.repository.db

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.taukir.movieappforcodingtest.model.ImdbMovie

interface ImdbMovieDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movies: List<ImdbMovie>)

    @Query("SELECT * FROM movies_table")
    fun getAllImdbMovies(): LiveData<List<ImdbMovie>>

    @Query("DELETE FROM movies_table")
    suspend fun clear()
}