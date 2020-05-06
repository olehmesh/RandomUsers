package com.olehmesh.randomusers.di.module

import androidx.navigation.fragment.NavHostFragment
import com.olehmesh.randomusers.di.scope.AppScope
import dagger.Module
import dagger.Provides


@Module
class NavModule {

    @AppScope
    @Provides
    fun provideNavHostFragment(): NavHostFragment {
        return NavHostFragment()
    }


}

