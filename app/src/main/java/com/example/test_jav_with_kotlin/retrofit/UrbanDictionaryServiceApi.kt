package com.example.test_jav_with_kotlin.retrofit

import retrofit2.http.GET
import retrofit2.http.Query

public interface UrbanDictionaryServiceApi {
    @GET()
    fun getListOfWords(@Query("term") searchWords: String)
}