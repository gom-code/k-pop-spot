package com.example.k_pop.Post

data class PostTempLoginResponse (
        val message: String,
        val data: TempData
)

data class TempData (
        val id: String,
        val authorization: String
)
