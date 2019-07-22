package com.olehmesh.randomusers_task.common

abstract class Callback<T> {

    abstract fun returnResult(t: T)

    abstract fun returnError(message: String)

}


