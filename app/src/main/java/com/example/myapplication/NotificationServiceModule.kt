package com.example.myapplication

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NotificationServiceModule {

    @Provides
    @Singleton
    fun getMessageService(): NotificationServices{
        return MessageService()
    }
}