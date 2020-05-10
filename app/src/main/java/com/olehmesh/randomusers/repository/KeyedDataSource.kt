package com.olehmesh.randomusers.repository

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.olehmesh.randomusers.repository.models.Result
import com.olehmesh.randomusers.repository.network.ApiInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class KeyedDataSource(context: CoroutineContext) : PageKeyedDataSource<String, Result>() {
    //private val apiService =   ApiClient.getClient().create(ApiService::class.java)

    private val job = Job()
    private val scope = CoroutineScope(context + job)
    private val apiService = ApiInstance.client!!

    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, Result>
    ) {
        scope.launch {
            try {
                val response = apiService.fetchUsers(loadSize = params.requestedLoadSize)
                when {
                    response.isSuccessful -> {
                        val listing = response.body()?.results
                        //      val redditPosts = listing?.results?.map { it.results }
                        //   callback.onResult((redditPosts ?: listOf()), listing?.before, listing?.after)
                    }
                }

            } catch (exception: Exception) {
                Log.e("PostsDataSource", "Failed to fetch data!")
            }

        }

    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, Result>) {
        scope.launch {
            try {
                val response =
                    apiService.fetchUsers(loadSize = params.requestedLoadSize, after = 0)
                when {
                    response.isSuccessful -> {
                        val listing = response.body()?.results
                        //  val items = listing?.results?.map { it.results }
                        //   callback.onResult((items ?: listOf()), listing?.after)
                    }
                }

            } catch (exception: Exception) {
                Log.e("PostsDataSource", "Failed to fetch data!")
            }
        }

    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, Result>) {
        scope.launch {
            try {
                val response =
                    apiService.fetchUsers(loadSize = params.requestedLoadSize, before = 0)
                when {
                    response.isSuccessful -> {
                        val listing = response.body()?.results
                        //   val items = listing?.results?.map { it.results }
                        //    callback.onResult((items ?: listOf()), listing?.after)
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