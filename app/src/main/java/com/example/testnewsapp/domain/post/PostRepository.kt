package com.example.testnewsapp.domain.post

import com.example.testnewsapp.data.post.Post

interface PostRepository {
    suspend fun getPosts():List<Post>
}