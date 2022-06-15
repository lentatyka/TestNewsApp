package com.example.testnewsapp.data.comment


import com.google.gson.annotations.SerializedName

data class Comment(
    @SerializedName("name")
    val title: String,
    @SerializedName("body")
    val body: String,
    val img: String
){
    companion object{
        val imgList = listOf(
            "https://cs6.pikabu.ru/avatars/404/x404070-828004264.png",
            "https://cs8.pikabu.ru/avatars/2057/x2057012-3861594.png",
            "https://cs6.pikabu.ru/avatars/521/v521522.jpg?924365380",
            "https://cs8.pikabu.ru/avatars/2298/x2298148-1823147349.png",
            "https://cs13.pikabu.ru/avatars/3086/x3086147-1733951488.png"
        )
    }
}