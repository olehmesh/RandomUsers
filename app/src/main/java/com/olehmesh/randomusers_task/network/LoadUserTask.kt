package com.olehmesh.randomusers_task.network

import com.olehmesh.randomusers_task.Constants
import com.olehmesh.randomusers_task.common.Callback
import com.olehmesh.randomusers_task.models.ApiResponse
import com.olehmesh.randomusers_task.models.Result
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

object LoadUserTask {

    fun getUsers(callback: Callback<List<Result>>) {

        RetrofitInstance.client!!
            .fetchUsers(Constants.QUANTITY_USERS)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<ApiResponse>() {

                override fun onSuccess(apiResponse: ApiResponse) {
                    val mlist = apiResponse.results
                    callback.returnResult(mlist)
                }

                override fun onError(e: Throwable) {
                    callback.returnError(e.message)

                }

            })

    }
}

