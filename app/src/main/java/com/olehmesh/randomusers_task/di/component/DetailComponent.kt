package com.olehmesh.randomusers_task.di.component

import com.olehmesh.randomusers_task.di.module.PojoModule
import com.olehmesh.randomusers_task.di.scope.DetailScope
import com.olehmesh.randomusers_task.views.DetailFragment
import dagger.Subcomponent

@DetailScope
@Subcomponent(modules = [PojoModule::class])
interface DetailComponent {

    fun inject(detailFragment: DetailFragment)

}