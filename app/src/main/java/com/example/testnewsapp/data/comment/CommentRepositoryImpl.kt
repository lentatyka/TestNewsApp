package com.example.testnewsapp.data.comment

import com.example.testnewsapp.domain.comment.CommentRepository
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val commentApi: CommentApi
):CommentRepository {

    override suspend fun invoke(postId: Int) = commentApi.getComments(postId)
}