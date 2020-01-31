package com.example.k_pop.data

data class RecommendSpotData (
        val main_title : String,
        val sub_title : String,
        val url : String
)
data class RelativeSpotData(
        val url : String,
        val title : String,
        val context : String,
        val address : String,
        val likeCnt : String
)
