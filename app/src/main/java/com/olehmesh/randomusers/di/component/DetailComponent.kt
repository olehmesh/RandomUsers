package com.olehmesh.randomusers.di.component

import com.olehmesh.randomusers.di.module.PojoModule
import com.olehmesh.randomusers.di.scope.DetailScope
import com.olehmesh.randomusers.presentation.fragments.DetailFragment
import dagger.Subcomponent

@DetailScope
@Subcomponent(modules = [PojoModule::class])
interface DetailComponent {

    fun inject(detailFragment: DetailFragment)

}