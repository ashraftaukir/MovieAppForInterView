package com.taukir.movieappforcodingtest.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.taukir.movieappforcodingtest.repository.db.ImdbMovieDatabaseDao
import com.taukir.movieappforcodingtest.model.ImdbMovie


@Database(entities = [ImdbMovie::class], version = 1, exportSchema = false)
abstract class ImdbMovieDatabase:RoomDatabase(), ImdbMovieDatabaseDao {
    abstract val movieDatabaseDao: ImdbMovieDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: ImdbMovieDatabaseDao? = null

        fun getInstance(context: Context): ImdbMovieDatabaseDao {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ImdbMovieDatabase::class.java,
                        "imdb_movie_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }

}