package com.olehmesh.randomusers_task.common

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.olehmesh.randomusers_task.models.Result

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface ContractView : MvpView {

    fun init()

    fun showProgress()

    fun hideProgress()

    fun showError(message: String)

    fun loadDataInList(users: List<Result>)

}



