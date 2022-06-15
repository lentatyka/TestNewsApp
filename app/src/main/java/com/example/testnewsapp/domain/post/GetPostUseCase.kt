package com.example.testnewsapp.domain.post

import com.example.testnewsapp.common.State
import com.example.testnewsapp.data.post.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPostUseCase @Inject constructor(
    private val repository: PostRepository
) {
    suspend fun getPosts(): Flow<State<List<Post>>>{
        return flow {
            try {
                emit(State.Loading)
                val result = repository.getPosts()
                emit(State.Success(result))
            }catch (e: IOException){
                emit(State.Error(e.localizedMessage ?: "unknown error"))
            }catch (e: HttpException){
                emit(State.Error(e.localizedMessage ?: "unknown error"))
            }
        }
    }
}