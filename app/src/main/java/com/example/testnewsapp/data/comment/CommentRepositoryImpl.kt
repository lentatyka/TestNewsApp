package com.example.testnewsapp.data.comment

import com.example.testnewsapp.domain.comment.CommentRepository
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val commentApi: CommentApi
):CommentRepository {

    override suspend fun invoke(postId: Int): List<Comment> {
        return commentApi.getComments(postId).map {comment ->
            comment.copy(img = Comment.imgList.random())    //set random image for example
        }
    }
}