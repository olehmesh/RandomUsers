package com.olehmesh.randomusers.repository


import android.util.Log
import androidx.annotation.NonNull
import androidx.paging.PositionalDataSource
import com.olehmesh.randomusers.repository.retrofit_pojo.Result
import com.olehmesh.randomusers.repository.network.ApiInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class MyPositionalDataSource(context: CoroutineContext) : PositionalDataSource<Result?>() {

    private val job = Job()
    private val scope = CoroutineScope(context + job)
    private val apiService = ApiInstance.client!!

    override fun loadInitial(
        @NonNull params: LoadInitialParams,
        @NonNull callback: LoadInitialCallback<Result?>
    ) {

        scope.launch {

            try {
                val response = apiService.fetchUsers(loadSize = params.requestedLoadSize)
                when {
                    response.isSuccessful -> {
                        //   val listing = response.body()?.results
                        // listing?.let { callback.onResult(it, 0) }

                    }

                }


            } catch (exception: Exception) {
                Log.e("PostsDataSource", "Failed to fetch data!")
            }
        }

    }

    override fun loadRange(
        @NonNull params: LoadRangeParams,
        @NonNull callback: LoadRangeCallback<Result?>
    ) {

        scope.launch(Dispatchers.Main) {

            try {
                val response = apiService.fetchUsers(loadSize = params.loadSize)
                when {
                    response.isSuccessful -> {
                        // val listing = response.body()?.results
                        // listing?.let { callback.onResult(it) }

                    }

                }


            } catch (exception: Exception) {
                Log.e("PostsDataSource", "Failed to fetch data!")
            }
        }
    }


    override fun invalidate() {
        super.invalidate()
        job.cancel()
    }

}