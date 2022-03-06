package com.yjk.common.http.api

import com.yjk.common.http.datamodel.youtube.YoutubeChannelResponse
import com.yjk.common.http.datamodel.youtube.YoutubeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi {


    //    @GET("search?key={API_KEY}&part=snippet&q={keyword}&pageToken={pageToken}")
    @GET("search")
    fun search(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("q") keyword: String,
        @Query("pageToken") pageToken: String,
        @Query("regionCode") regionCode: String
    ): Call<YoutubeResponse>

    @GET("channels")
    fun searchChannel(
        @Query("key") key: String,
        @Query("part") part: String,
        @Query("id") channelId: String
    ): Call<YoutubeChannelResponse>

}