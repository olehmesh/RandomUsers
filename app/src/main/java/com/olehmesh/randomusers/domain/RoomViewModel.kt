package com.olehmesh.randomusers.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.olehmesh.randomusers.repository.database.DBInteract
import com.olehmesh.randomusers.repository.database.DatabaseManager
import com.olehmesh.randomusers.repository.database.entity.UserEntity

class RoomViewModel(application: Application) : AndroidViewModel(application) {

    private val dbInteract: DBInteract
    val dbLiveData: LiveData<MutableList<UserEntity>>

    init {

        val usersDao = DatabaseManager.getDatabase(application)!!.daoUserInfo()
        dbInteract = DBInteract(usersDao)
        dbLiveData = dbInteract.allDaoUser

    }
}