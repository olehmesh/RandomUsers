package com.olehmesh.randomusers.repository

import android.util.Log
import androidx.paging.ItemKeyedDataSource
import com.olehmesh.randomusers.di.App
import com.olehmesh.randomusers.repository.network.ApiService
import com.olehmesh.randomusers.repository.network.retrofit_pojo.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext


class ItemKeyedSource(context: CoroutineContext) : ItemKeyedDataSource<String, Result>() {

    @Inject
    lateinit var api: ApiService

    private val job = Job()
    private val scope = CoroutineScope(context + job)

    override fun loadInitial(
        params: LoadInitialParams<String?>,
        callback: LoadInitialCallback<Result?>
    ) {

        App.component.inject(this)

        scope.launch {
            try {
                val response = api.fetchUsers(loadSize = params.requestedLoadSize)
                when {

                    response.isSuccessful -> {
                        val list = response.body()?.results
                        list?.let { callback.onResult(it) }
                    }
                }

            } catch (exception: Exception) {
                Log.e("Paging", "No data")
            }

        }

    }

    override fun loadAfter(params: LoadParams<String?>, callback: LoadCallback<Result?>) {

        scope.launch {

            try {
                val response = api.fetchUsers(after = params.requestedLoadSize)
                when {
                    response.isSuccessful -> {
                        val list = response.body()?.results
                        list?.let { callback.onResult(it) }
                    }
                }

            } catch (exception: Exception) {
                Log.e("Paging", "No data")
            }

        }
    }

    override fun loadBefore(params: LoadParams<String?>, callback: LoadCallback<Result?>) {
        scope.launch {
            try {
                val response = api.fetchUsers(after = params.requestedLoadSize)
                when {
                    response.isSuccessful -> {
                        val list = response.body()?.results
                        list?.let { callback.onResult(it) }
                    }
                }

            } catch (exception: Exception) {
                Log.e("Paging", "No data")
            }

        }

    }

    override fun getKey(item: Result): String {
        return item.toString()
    }

}