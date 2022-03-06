package com.yjk.atry._3_youtube.presenter

import android.content.Context
import com.yjk.atry._3_youtube.viewmodel.YoutubeViewModel
import com.yjk.common.db.datamodel.YoutubeSearchDataModel
import com.yjk.common.db.repository.DataRepository
import com.yjk.common.http.RetrofitManager
import com.yjk.common.http.api.YoutubeApi
import com.yjk.common.http.datamodel.youtube.YoutubeChannelResponse
import com.yjk.common.http.datamodel.youtube.YoutubeResponse
import com.yjk.common.util.TLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YoutubePresenter(val context: Context, val viewModel: YoutubeViewModel) {

    private val API_KEY = "AIzaSyBDQu6g3qOfwNfax_9yYgZGuXO2rYTiagc"

    private val PART_SNIPPET = "snippet"
    private val PART_STATISTICS = "statistics"
    private val REGION_CODE = "KR"

    private var pageToken = ""

    private val db = DataRepository(context)

    /**
     * 영상 리스트
     */
    fun loadList(keyword: String) {

        //tt
        RetrofitManager.getInstance()!!.getRetrofitForYouTube().create(YoutubeApi::class.java)
            .search(API_KEY, PART_SNIPPET, keyword, pageToken, REGION_CODE)
            .enqueue(object : Callback<YoutubeResponse> {
                override fun onResponse(
                    call: Call<YoutubeResponse>,
                    response: Response<YoutubeResponse>
                ) {
                    TLog.d("영상 리스트 : ${response.body().toString()}")
                    val list = response.body()!!.items
                    pageToken = response.body()!!.nextPageToken!!

                    if (list == null) {
                        // 영상 없음

                    } else {
                        viewModel.videoLiveData.postValue(list)
                    }

                }

                override fun onFailure(call: Call<YoutubeResponse>, t: Throwable) {
                    TLog.d("Error : ${t.localizedMessage}")
                }
            })
    }

    /**
     * 채널 정보
     */
    fun loadChannelInfo(channelId: String) {

        RetrofitManager.getInstance()!!.getRetrofitForYouTube().create(YoutubeApi::class.java)
            .searchChannel(API_KEY, "$PART_SNIPPET,$PART_STATISTICS", channelId)
            .enqueue(object : Callback<YoutubeChannelResponse> {
                override fun onResponse(
                    call: Call<YoutubeChannelResponse>,
                    response: Response<YoutubeChannelResponse>
                ) {
                    TLog.d("채널 info : ${response.body().toString()}")
                    val list = response.body()!!.items

                    if (list == null) {
                        // 영상 없음

                    } else {
                        viewModel.channelLiveData.postValue(list[0])
                    }

                }

                override fun onFailure(call: Call<YoutubeChannelResponse>, t: Throwable) {
                    TLog.d("Error : ${t.localizedMessage}")
                }
            })
    }

    /**
     * 저장된 검색어 리스트
     */
    fun getSearchWordList(): List<YoutubeSearchDataModel> {
        return db.youtubeSearchDao.findAll()
    }
}