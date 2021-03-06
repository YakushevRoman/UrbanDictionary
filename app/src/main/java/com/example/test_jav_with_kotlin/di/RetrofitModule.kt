package com.example.test_jav_with_kotlin.di

import com.example.test_jav_with_kotlin.retrofit.RetrofitSettings
import com.example.test_jav_with_kotlin.retrofit.UrbanDictionaryServiceApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule {

    @Provides
    fun getHttpInterceptor(): HttpLoggingInterceptor {
        val httpInterceptor = HttpLoggingInterceptor()
        httpInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpInterceptor
    }

    @Provides
    fun getGson(): Gson =
            GsonBuilder().create()


    @Provides
    fun getConverterFactory(gson : Gson) : GsonConverterFactory =
            GsonConverterFactory.create(gson)

    @Provides
    fun getCallAdapterFactory () : RxJava3CallAdapterFactory =
            RxJava3CallAdapterFactory.create()

    @Provides
    fun getOkHttpClient(httpInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient().newBuilder()
        okHttpClientBuilder.addInterceptor(httpInterceptor)
        return okHttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient, factory: GsonConverterFactory, rxJava2CallAdapterFactory: RxJava3CallAdapterFactory): Retrofit {
        val retrofit: Retrofit.Builder = Retrofit.Builder()
        retrofit.baseUrl(RetrofitSettings.baseUrl)
        retrofit.addConverterFactory(factory)
        retrofit.addCallAdapterFactory(rxJava2CallAdapterFactory)
        retrofit.client(okHttpClient)
        return retrofit.build()
    }

    @Provides
    fun getUrbanDictionaryAPi(retrofit: Retrofit): UrbanDictionaryServiceApi =
            retrofit.create(UrbanDictionaryServiceApi::class.java)

}