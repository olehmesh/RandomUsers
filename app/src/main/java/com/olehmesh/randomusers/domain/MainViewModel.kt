package com.olehmesh.randomusers.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.*
import com.olehmesh.randomusers.repository.ItemKeyedSource
import com.olehmesh.randomusers.repository.network.retrofit_pojo.Result
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