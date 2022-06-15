package com.example.testnewsapp.data.comment

import retrofit2.http.GET
import retrofit2.http.Path

interface CommentApi {

    @GET("posts/{postId}/comments")
    suspend fun getComments(@Path("postId") postId: Int):List<Comment>
}