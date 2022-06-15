package com.example.testnewsapp.data.post

import com.example.testnewsapp.domain.post.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val serviceApi: PostApi
) : PostRepository {
    override suspend fun getPosts() = serviceApi.getPosts()
}