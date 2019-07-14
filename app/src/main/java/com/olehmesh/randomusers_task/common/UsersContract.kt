package com.olehmesh.randomusers_task.common

import com.olehmesh.randomusers_task.models.Result

class UsersContract {

    interface View {

        fun init()

        fun showProgress()

        fun hideProgress()

        fun showError(message: String)

        fun loadDataInList(users: List<Result>)

    }

    interface Presenter {

        fun onRefreshButtonClick()

        fun start()

        fun loadUsers()
    }

}
