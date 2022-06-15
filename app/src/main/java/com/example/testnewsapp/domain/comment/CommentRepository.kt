package com.example.testnewsapp.domain.comment

import com.example.testnewsapp.data.comment.Comment

interface CommentRepository {
    suspend operator fun invoke(postId: Int):List<Comment>
}