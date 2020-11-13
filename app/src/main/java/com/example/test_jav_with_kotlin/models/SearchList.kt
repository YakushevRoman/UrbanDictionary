package com.example.test_jav_with_kotlin.models

import androidx.room.Entity

@Entity()
data class SearchList (
        val searchResults : List<Search>
)