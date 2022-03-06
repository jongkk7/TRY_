package com.yjk.atry._3_youtube.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yjk.common.http.datamodel.youtube.YoutubeChannelDataModel
import com.yjk.common.http.datamodel.youtube.YoutubeDataModel

class YoutubeViewModel : ViewModel() {

    val videoLiveData : MutableLiveData<ArrayList<YoutubeDataModel>> by lazy {
        MutableLiveData<ArrayList<YoutubeDataModel>>()
    }

    val channelLiveData : MutableLiveData<YoutubeChannelDataModel> by lazy {
        MutableLiveData<YoutubeChannelDataModel>()
    }

}