package com.olehmesh.randomusers_task.common

import com.olehmesh.randomusers_task.models.Result

abstract class Callback<T> {

    abstract fun returnResult(t: List<Result>)

    abstract fun returnError(message: String)

}


