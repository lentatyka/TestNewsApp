package com.example.testnewsapp.di

import com.example.testnewsapp.common.Constants.BASE_URL
import com.example.testnewsapp.data.ServiceApi
import com.example.testnewsapp.data.post.PostRepositoryImpl
import com.example.testnewsapp.domain.post.PostRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class PostModule {

    @Binds
    abstract fun bindPostRepository(repo: PostRepositoryImpl):PostRepository

    companion object{
        @Singleton
        @Provides
        fun provideServiceApi():ServiceApi{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ServiceApi::class.java)
        }
    }
}