package com.example.k_pop.Network

import android.app.Application
import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApplicationController : Application() {
    lateinit var networkService: NetworkService

    //private val baseUrl = "https://jungnami.ml/"
    private val baseUrl = "http://192.168.56.1:3000/"
    companion object {
        lateinit var instance : ApplicationController
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("ㅋㅋ", "시발")
        instance = this
        buildNetwork()
    }

    fun buildNetwork(){

        val builder = Retrofit.Builder()
        val retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        networkService = retrofit.create(NetworkService::class.java)
    }
}