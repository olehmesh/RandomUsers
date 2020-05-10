package com.olehmesh.randomusers.repository.database

import androidx.lifecycle.LiveData
import com.olehmesh.randomusers.repository.database.dao.DaoUserInfo
import com.olehmesh.randomusers.repository.database.entity.UserEntity

class DBInteract(private val daoUserInfo: DaoUserInfo) {

    val allDaoUser: LiveData<MutableList<UserEntity>> = daoUserInfo.all

}