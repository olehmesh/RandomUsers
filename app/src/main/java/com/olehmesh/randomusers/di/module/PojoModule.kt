package com.olehmesh.randomusers.di.module

import com.olehmesh.randomusers.repository.database.entity.DateCurrent
import com.olehmesh.randomusers.repository.database.entity.UserEntity
import com.olehmesh.randomusers.di.scope.DetailScope
import dagger.Module
import dagger.Provides

@Module
class PojoModule {

    @DetailScope
    @Provides
    fun provideUserInfo(): UserEntity {
        return UserEntity()
    }

    @DetailScope
    @Provides
    fun provideDateCurrent(): DateCurrent {
        return DateCurrent()
    }

}