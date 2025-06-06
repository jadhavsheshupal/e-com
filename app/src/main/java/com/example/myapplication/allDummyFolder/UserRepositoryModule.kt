package com.example.myapplication.allDummyFolder

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserRepositoryModule {

    @Provides
    @Singleton
    fun getUserRepository(): UserRepository{
        return FireBaseRepository()
    }
}