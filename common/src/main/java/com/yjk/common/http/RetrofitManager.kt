package com.yjk.common.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitManager {

    companion object{

        // open api 경로
        private const val openApiUrl = "https://www.data.go.kr"
        private const val youTubeApiUrl = "https://www.googleapis.com/youtube/v3/"

        private var instance: RetrofitManager? = null

        // singleton
        fun getInstance(): RetrofitManager? {
            if (instance == null) {
                instance = RetrofitManager()
            }
            return instance
        }

    }

    // retrofit 객채 생성
    fun getRetrofitForOpenApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(openApiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getRetrofitForYouTube(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(youTubeApiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}