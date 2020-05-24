package com.olehmesh.randomusers.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.olehmesh.randomusers.di.App
import com.olehmesh.randomusers.repository.database.DatabaseManager
import com.olehmesh.randomusers.repository.database.relation.DateAndUser
import javax.inject.Inject


class RoomViewModel : ViewModel() {

    var dbLiveData: LiveData<MutableList<DateAndUser>>

    @Inject
    lateinit var db: DatabaseManager

    init {
        App.component.inject(this)
        val usersAndDateDao = db.daoUserAndDate().getDateAndUsers()
        dbLiveData = usersAndDateDao
    }
}
