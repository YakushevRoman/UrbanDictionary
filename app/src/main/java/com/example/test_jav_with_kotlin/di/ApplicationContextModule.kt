package com.example.test_jav_with_kotlin.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationContextModule constructor(val app: Application){

    @Provides
    fun getApplicationContext() : Context = app.applicationContext

    @Provides
    fun provideApplication () : Application = app
}