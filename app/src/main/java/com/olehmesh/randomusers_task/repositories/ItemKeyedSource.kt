package com.olehmesh.randomusers_task.repositories

import android.util.Log
import androidx.paging.ItemKeyedDataSource
import com.olehmesh.randomusers_task.models.Result
import com.olehmesh.randomusers_task.network.ApiInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class ItemKeyedSource(context: CoroutineContext) : ItemKeyedDataSource<String, Result>() {

    private val job = Job()
    private val scope = CoroutineScope(context + job)
    private val apiService = ApiInstance.client!!


    override fun loadInitial(
        params: LoadInitialParams<String?>,
        callback: LoadInitialCallback<Result?>
    ) {


        scope.launch {
            try {
                val response = apiService.fetchUsers(loadSize = params.requestedLoadSize)
                when {
                    response.isSuccessful -> {
                        val listing = response.body()?.results
                        // val redditPosts = listing?.results?.map { it.results }
                        listing?.let { callback.onResult(it) }
                    }
                }

            } catch (exception: Exception) {
                Log.e("PostsDataSource", "Failed to fetch data!")
            }

        }


    }

    override fun loadAfter(params: LoadParams<String?>, callback: LoadCallback<Result?>) {
        scope.launch {
            try {
                val response = apiService.fetchUsers(after = params.requestedLoadSize)
                when {
                    response.isSuccessful -> {
                        val listing = response.body()?.results
                        // val redditPosts = listing?.results?.map { it.results }
                        listing?.let { callback.onResult(it) }
                    }
                }

            } catch (exception: Exception) {
                Log.e("PostsDataSource", "Failed to fetch data!")
            }

        }
    }

    override fun loadBefore(params: LoadParams<String?>, callback: LoadCallback<Result?>) {
        scope.launch {
            try {
                val response = apiService.fetchUsers(after = params.requestedLoadSize)
                when {
                    response.isSuccessful -> {
                        val listing = response.body()?.results
                        //  val redditPosts = listing?.results?.map { it.results }
                        listing?.let { callback.onResult(it) }
                    }
                }

            } catch (exception: Exception) {
                Log.e("PostsDataSource", "Failed to fetch data!")
            }

        }
    }

    override fun getKey(item: Result): String {
        return item.name.toString()
    }

}