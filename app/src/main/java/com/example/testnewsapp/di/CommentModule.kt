package com.example.testnewsapp.di

import com.example.testnewsapp.common.Constants.BASE_URL
import com.example.testnewsapp.data.comment.CommentApi
import com.example.testnewsapp.data.comment.CommentRepositoryImpl
import com.example.testnewsapp.domain.comment.CommentRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
abstract class CommentModule {

    @Binds
    abstract fun bindCommentRepository(repo: CommentRepositoryImpl): CommentRepository

    companion object{
        @Provides
        fun provideServiceApi(): CommentApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CommentApi::class.java)
        }
    }
}