package com.dew.edward.test

import android.app.Activity
import android.app.Application
import com.dew.edward.test.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


/**
 * Created by Edward on 7/14/2018.
 */
class App : Application(), HasActivityInjector{

    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject set

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
                .create()
                .inject(this)

//        DaggerAppComponent.builder()
//                .application(this)
//                .build()
//                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }
}