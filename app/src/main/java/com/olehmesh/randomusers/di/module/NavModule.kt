package com.olehmesh.randomusers.di.module

import androidx.navigation.fragment.NavHostFragment
import com.olehmesh.randomusers.di.scope.ApiScope
import dagger.Module
import dagger.Provides


@Module
class NavModule {

    @ApiScope
    @Provides
    fun provideNavHostFragment(): NavHostFragment {
        return NavHostFragment()
    }


}

