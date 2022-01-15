package com.yjk.atry.http

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitManager {

    companion object{

        // open api 경로
        private val openApiUrl = "https://www.data.go.kr"

        private var instance: RetrofitManager? = null

        // singleton ( 디자인패턴에 관해서는 추 후에 설명.. )
        fun getInstance(): RetrofitManager? {
            if (instance == null) {
                instance = RetrofitManager()
            }
            return instance
        }

    }

    // retrofit 객채 생성
    fun getRetrofit(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl(openApiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}