package com.example.myapplication.allDummyFolder

import com.example.myapplication.allDummyFolder.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {

    fun inject(mainActivity: MainActivity)

}