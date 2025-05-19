package com.example.myapplication

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {

    fun inject(mainActivity: MainActivity)

}