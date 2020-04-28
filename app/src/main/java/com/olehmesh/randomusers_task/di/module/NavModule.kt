package com.olehmesh.randomusers_task.di.module

import android.app.Activity
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.olehmesh.randomusers_task.MainActivity
import com.olehmesh.randomusers_task.R
import com.olehmesh.randomusers_task.di.scope.AppScope
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

