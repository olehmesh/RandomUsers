package com.olehmesh.randomusers.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.olehmesh.randomusers.repository.database.DatabaseManager
import com.olehmesh.randomusers.repository.database.relation.DateAndUser

class RoomViewModel(application: Application) : AndroidViewModel(application) {

    var dbLiveData: LiveData<MutableList<DateAndUser>>

    init {

        val usersDao = DatabaseManager.getDatabase(application)!!.daoUserAndDate().getDateAndUsers()

        dbLiveData = usersDao
    }

}