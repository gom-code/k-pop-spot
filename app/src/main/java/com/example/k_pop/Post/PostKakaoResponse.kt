package com.example.k_pop.Post

data class PostKakaoResponse (
        val message: String,
        val data: KakaoData
)

data class KakaoData (
        val id: Int,
        val authorization: String
)
