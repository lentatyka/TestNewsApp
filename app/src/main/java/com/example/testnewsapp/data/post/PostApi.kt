package com.example.testnewsapp.data.post

import com.example.testnewsapp.data.comment.Counter
import retrofit2.http.GET

interface PostApi {

    @GET("posts")
    suspend fun getPosts():List<Post>

    @GET("comments")
    suspend fun countComments():List<Counter>
}