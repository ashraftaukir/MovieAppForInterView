package com.taukir.movieappforcodingtest.repository.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.taukir.movieappforcodingtest.model.Movie

@Dao
interface MovieDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movies: List<Movie>)

    @Query("SELECT * FROM movies_table")
    fun getAllImdbMovies(): LiveData<List<Movie>>

    @Query("DELETE FROM movies_table")
    suspend fun clear()
}