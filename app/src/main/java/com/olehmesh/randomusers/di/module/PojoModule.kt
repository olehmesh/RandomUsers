package com.olehmesh.randomusers.di.module

import com.olehmesh.randomusers.database.entity.DateCurrent
import com.olehmesh.randomusers.database.entity.UserInfo
import com.olehmesh.randomusers.di.scope.DetailScope
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