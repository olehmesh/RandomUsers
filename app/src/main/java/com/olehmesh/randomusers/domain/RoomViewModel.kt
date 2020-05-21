package com.olehmesh.randomusers.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.olehmesh.randomusers.repository.database.DBInteract
import com.olehmesh.randomusers.repository.database.DatabaseManager
import com.olehmesh.randomusers.repository.database.relation.DateAndInfo

class RoomViewModel(application: Application) : AndroidViewModel(application) {

    private val dbInteract: DBInteract
    val dbLiveData: LiveData<MutableList<DateAndInfo>>

    init {

        val usersDao = DatabaseManager.getDatabase(application)!!.daoUserAndDate()
        dbInteract = DBInteract(usersDao)
        dbLiveData = dbInteract.requestAll

    }
}