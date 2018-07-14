package com.dew.edward.test.di

import com.dew.edward.test.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by Edward on 7/14/2018.
 */

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class), BuildersModule::class])
interface AppComponent {

    fun inject(application: App)

//    @Component.Builder
//    interface Builder{
//
//        @BindsInstance
//        fun application(application: App): Builder
//
//        fun build(): AppComponent
//    }
}