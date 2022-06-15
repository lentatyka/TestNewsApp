package com.example.testnewsapp.data.post

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
    val commentsCount:Int?
)
