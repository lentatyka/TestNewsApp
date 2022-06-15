package com.example.testnewsapp.data.comment

import com.google.gson.annotations.SerializedName

data class Counter(
    @SerializedName("postId")
    val postId: Int
)
