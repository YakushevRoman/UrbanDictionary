package com.example.test_jav_with_kotlin.app.di

import com.example.test_jav_with_kotlin.retrofit.UrbanDictionaryServiceApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule {
    private val BASE_URL: String = "https://mashape-community-urban-dictionary.p.rapidapi.com/define"

    @Provides
    fun getHttpInterceptor(): HttpLoggingInterceptor {
        val httpInterceptor = HttpLoggingInterceptor()
        httpInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpInterceptor
    }

    @Provides
    fun getGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun getConverterFactory(gson : Gson) : GsonConverterFactory{
        return  GsonConverterFactory.create(gson)
    }
    @Provides
    fun getCallAdapterFactory () : RxJava2CallAdapterFactory{
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    fun getOkHttpClient(httpInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient().newBuilder()
        okHttpClientBuilder.addInterceptor(httpInterceptor)
        return okHttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun getRetrofit(okHttpClient: OkHttpClient, factory: GsonConverterFactory, rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): Retrofit {
        val retrofit: Retrofit.Builder = Retrofit.Builder()
        retrofit.baseUrl(BASE_URL)
        retrofit.addConverterFactory(factory)
        retrofit.addCallAdapterFactory(rxJava2CallAdapterFactory)
        retrofit.client(okHttpClient)
        return retrofit.build()
    }

    @Provides
    fun getUrbanDictionaryAPi(retrofit: Retrofit): UrbanDictionaryServiceApi {
        return retrofit.create(UrbanDictionaryServiceApi::class.java)
    }
}