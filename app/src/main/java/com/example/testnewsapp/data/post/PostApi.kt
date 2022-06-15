package com.example.testnewsapp.data.post

import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    suspend fun getPosts():List<Post>
}