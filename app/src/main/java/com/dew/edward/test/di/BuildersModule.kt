package com.dew.edward.test.di

import com.dew.edward.test.lobby.MainActivity
import com.dew.edward.test.lobby.LobbyActivityModule
import com.dew.edward.test.lobby.LobbyFragment
import com.dew.edward.test.lobby.LobbyFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


/**
 * Created by Edward on 7/14/2018.
 */

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [LobbyActivityModule::class])
    abstract fun bindMainActivity(): MainActivity


    @ContributesAndroidInjector(modules = [LobbyFragmentModule::class, LobbyActivityModule::class])
    abstract fun bindLobbyFragment(): LobbyFragment

}