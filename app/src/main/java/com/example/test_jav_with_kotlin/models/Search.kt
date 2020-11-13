package com.example.test_jav_with_kotlin.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Search(
        @PrimaryKey(autoGenerate = true)
        val primaryKey: Int,
        val definition: String,
        val permalink: String,
        val thumbs_up: Int,
        val sound_urls: List<String>,
        val author: String,
        val word: String,
        val defid: Int,
        val current_vote: String,
        val written_on: String,
        val example: String,
        val thumbs_down: Int
)