package com.example.testnewsapp.data.post

import com.example.testnewsapp.data.ServiceApi
import com.example.testnewsapp.domain.post.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val serviceApi: ServiceApi
) : PostRepository {
    override suspend fun getPosts() = serviceApi.getPosts()
}