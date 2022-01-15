package com.yjk.atry.http.api

import com.yjk.atry._102_http.datamodel.DefData
import retrofit2.Call
import retrofit2.http.GET




interface OpenApi {

    @GET("/cmm/cmm/fileDownload.do?atchFileId=FILE_000000002485629&fileDetailSn=2&insertDataPrcus=N")
    fun getDefData(): Call<ArrayList<DefData>>

}