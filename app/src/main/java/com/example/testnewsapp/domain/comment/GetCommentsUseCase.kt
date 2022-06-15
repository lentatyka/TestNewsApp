package com.example.testnewsapp.domain.comment

import com.example.testnewsapp.common.State
import com.example.testnewsapp.data.comment.Comment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCommentsUseCase @Inject constructor(
    private val repository: CommentRepository
) {
    suspend operator fun invoke(postId: Int): Flow<State<List<Comment>>> {
        return flow {
            try {
                emit(State.Loading)
                val result = repository(postId)
                emit(State.Success(result))
            } catch (e: IOException) {
                emit(State.Error(e.localizedMessage ?: "unknown error"))
            } catch (e: HttpException) {
                emit(State.Error(e.localizedMessage ?: "unknown error"))
            }
        }
    }
}