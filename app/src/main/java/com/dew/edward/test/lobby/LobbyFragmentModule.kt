package com.dew.edward.test.lobby

import dagger.Module
import dagger.Provides


/**
 * Created by Edward on 7/14/2018.
 */

@Module
class LobbyFragmentModule {

    @Provides
    fun provideLobbyFragmentHelloService(): LobbyFragmentHelloService {
        return LobbyFragmentHelloService()
    }
}