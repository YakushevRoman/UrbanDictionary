package com.example.test_jav_with_kotlin.di

import android.app.Application
import androidx.room.Room
import com.example.test_jav_with_kotlin.UrbanApplication
import com.example.test_jav_with_kotlin.data_base.UrbanDictionaryDataBase
import com.example.test_jav_with_kotlin.data_base.daos.SearchDao
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

@Module (includes = [ApplicationContextModule::class])
class RoomModule{
    private val DB_NAME: String = "search_data_base"

    @Singleton
    @Provides
    fun getDataBase(app : Application): UrbanDictionaryDataBase  = Room.databaseBuilder(app, UrbanDictionaryDataBase::class.java, DB_NAME).build()

    @Provides
    fun getSearchDao(dataBase: UrbanDictionaryDataBase) : SearchDao = dataBase.getSearchDao()

}