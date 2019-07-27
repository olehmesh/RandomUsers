package com.olehmesh.randomusers_task.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.olehmesh.randomusers_task.common.Callback
import com.olehmesh.randomusers_task.common.ContractView
import com.olehmesh.randomusers_task.models.Result
import com.olehmesh.randomusers_task.network.LoadUserTask

@InjectViewState
class UsersPresenter : MvpPresenter<ContractView>() {

    fun loadUsers() {

        LoadUserTask.getUsers(object : Callback<List<Result>>() {

            override fun returnResult(t: List<Result>) {

                viewState.loadDataInList(t)
                viewState.hideProgress()
            }

            override fun returnError(message: String) {

                viewState.showError(message)

            }
        })
    }

    fun onRefreshButtonClick() {

        viewState.showProgress()
    }

    fun start() {

        viewState.init()
    }

}
