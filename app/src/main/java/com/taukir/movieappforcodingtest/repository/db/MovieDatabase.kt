package com.taukir.movieappforcodingtest.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.taukir.movieappforcodingtest.model.Movie


@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MovieDatabase:RoomDatabase(){
    abstract val movieDatabaseDao: MovieDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getInstance(context: Context): MovieDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDatabase::class.java,
                        "sleep_history_database"
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