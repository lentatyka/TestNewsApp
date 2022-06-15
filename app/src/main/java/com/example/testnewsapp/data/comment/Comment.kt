package com.example.testnewsapp.data.comment


import com.google.gson.annotations.SerializedName

data class Comment(
    @SerializedName("name")
    val title: String,
    @SerializedName("body")
    val body: String,
    val img: String = ""
)