package com.example.test_jav_with_kotlin.retrofit

import com.example.test_jav_with_kotlin.models.SearchList
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface UrbanDictionaryServiceApi {
    @Headers(
            "x-rapidapi-key:f38c42c1c2mshf4600b185731c51p17539djsn12f22d32a112",
            "x-rapidapi-host:mashape-community-urban-dictionary.p.rapidapi.com"
    )
    @GET("define")
    fun getListOfWords(@Query("term") searchWords: String): Observable<SearchList>
}