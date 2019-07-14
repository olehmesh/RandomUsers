package com.olehmesh.randomusers_task.presenters

import com.olehmesh.randomusers_task.common.Callback
import com.olehmesh.randomusers_task.common.UsersContract
import com.olehmesh.randomusers_task.models.Result
import com.olehmesh.randomusers_task.network.LoadUserTask

class UsersPresenter(var mView: UsersContract.View) : UsersContract.Presenter {

    override fun loadUsers() {

        LoadUserTask.getUsers(object : Callback<List<Result>>() {

            override fun returnResult(users: List<Result>) {
                mView.loadDataInList(users)
                mView.hideProgress()

            }

            override fun returnError(message: String) {
                mView.showError(message)
            }
        })
    }

    override fun onRefreshButtonClick() {
        mView.showProgress()
    }

    override fun start() {
        mView.init()
    }

}
