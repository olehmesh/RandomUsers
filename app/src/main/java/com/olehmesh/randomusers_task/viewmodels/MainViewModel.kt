package com.olehmesh.randomusers_task.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import com.olehmesh.randomusers_task.models.Result
import com.olehmesh.randomusers_task.repositories.ItemKeyedSource
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    var liveData: LiveData<PagedList<Result>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .build()

        liveData = initPagedList(config).build()

    }

    fun getData(): LiveData<PagedList<Result>> = liveData

    private fun initPagedList(config: PagedList.Config): LivePagedListBuilder<String, Result> {

        val dataSourceFactory = object : DataSource.Factory<String, Result>() {

            override fun create(): DataSource<String, Result> {

                return ItemKeyedSource(Dispatchers.Main)

            }
        }

        return LivePagedListBuilder(dataSourceFactory, config)

    }
}