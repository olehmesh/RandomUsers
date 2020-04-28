package com.olehmesh.randomusers_task.di.module

import com.olehmesh.randomusers_task.database.entity.DateCurrent
import com.olehmesh.randomusers_task.database.entity.UserInfo
import com.olehmesh.randomusers_task.di.scope.DetailScope
import dagger.Module
import dagger.Provides

@Module
class PojoModule {

    @DetailScope
    @Provides
    fun provideUserInfo(): UserInfo {
        return UserInfo()
    }

    @DetailScope
    @Provides
    fun provideDateCurrent(): DateCurrent {
        return DateCurrent()
    }

}