package com.example.testnewsapp.data

import com.example.testnewsapp.data.post.Post
import retrofit2.http.GET

interface ServiceApi {

    @GET("posts")
    suspend fun getPosts():List<Post>
}