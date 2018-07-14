package com.dew.edward.test.di

import android.content.Context
import com.dew.edward.test.App
import com.dew.edward.test.common.CommonHelloService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by Edward on 7/14/2018.
 */

@Module
class AppModule {


    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideCommonHelloService(): CommonHelloService {
        return CommonHelloService()
    }
}