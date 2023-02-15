package com.taukir.movieappforcodingtest

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.taukir.movieappforcodingtest.repository.ImdbMovieDatabase
import retrofit2.HttpException

class RefreshDataWorker(appContext: Context, workerParams: WorkerParameters) :
    CoroutineWorker(appContext, workerParams) {


    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        val dataSource = ImdbMovieDatabase.getInstance(applicationContext)
        return try {
            val repository = ImdbMovieRepository(dataSource)
            repository.refreshMovies("batman")
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }

}