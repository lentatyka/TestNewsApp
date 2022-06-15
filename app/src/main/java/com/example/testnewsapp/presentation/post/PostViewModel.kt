package com.example.testnewsapp.presentation.post

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testnewsapp.common.State
import com.example.testnewsapp.data.post.Post
import com.example.testnewsapp.domain.post.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.FragmentScoped
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostUseCase: GetPostUseCase
) : ViewModel() {

    private val _state = MutableSharedFlow<State<List<Post>>>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val state: SharedFlow<State<List<Post>>> = _state.asSharedFlow()

    init {
        getPosts()
    }

    fun getPosts(){
        viewModelScope.launch {
            getPostUseCase.getPosts().collect {
                _state.emit(it)
            }
        }
    }
}