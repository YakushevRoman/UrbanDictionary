package com.example.test_jav_with_kotlin.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.test_jav_with_kotlin.data_base.type_conventers.SearchConverter
import java.io.Serializable

@Entity(tableName = "results_search_table")
data class SearchList (
        @PrimaryKey(autoGenerate = true)
        val id : Int,
        @TypeConverters(SearchConverter::class)
        val list : List<Search>,
        var searchWord: String
) : Serializable