package com.example.testnewsapp.data.post


import com.example.testnewsapp.domain.post.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val serviceApi: PostApi
) : PostRepository {
    override suspend fun getPosts(): List<Post> {
        val counter = serviceApi.countComments()    //Топорное решение.
        val posts = serviceApi.getPosts()
        return posts.map {post->
            post.copy(commentsCount = counter.count {counter ->
                counter.postId == post.id
            })
        }
    }

}