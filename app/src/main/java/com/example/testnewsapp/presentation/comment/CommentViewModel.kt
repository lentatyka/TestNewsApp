package com.example.testnewsapp.presentation.comment

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testnewsapp.common.State
import com.example.testnewsapp.data.comment.Comment
import com.example.testnewsapp.domain.comment.GetCommentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CommentViewModel @Inject constructor(
    private val getCommentsUseCase: GetCommentsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableSharedFlow<State<List<Comment>>>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val state: SharedFlow<State<List<Comment>>> = _state.asSharedFlow()

    init {
        val postId  = savedStateHandle.get<Int>("postId")
            viewModelScope.launch {
                postId?.let {
                    getCommentsUseCase(it).collect {
                        _state.emit(it)
                    }
                } ?:
                _state.emit(State.Error("unknown error"))
            }
    }
}