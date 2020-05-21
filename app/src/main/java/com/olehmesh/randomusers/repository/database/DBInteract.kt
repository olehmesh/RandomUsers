package com.olehmesh.randomusers.repository.database

import androidx.lifecycle.LiveData
import com.olehmesh.randomusers.repository.database.dao.DaoUserAndDate
import com.olehmesh.randomusers.repository.database.relation.DateAndInfo

class DBInteract(private val daoUserAndDate: DaoUserAndDate) {

    val requestAll: LiveData<MutableList<DateAndInfo>> = daoUserAndDate.getDateAndUsers()

}