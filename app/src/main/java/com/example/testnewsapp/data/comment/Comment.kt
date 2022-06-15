package com.example.testnewsapp.data.comment

import com.google.gson.annotations.SerializedName

data class Comment(
    @SerializedName("name")
    val title: String,
    val body: String
)