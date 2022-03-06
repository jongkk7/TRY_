package com.yjk.common.http.datamodel.youtube

class YoutubeResponse() {
    val kind: String? = null
    val etag: String? = null
    val id: Id? = null
    val prevPageToken: String? = null
    val nextPageToken: String? = null

    val regionCode: String? = null
    val items: ArrayList<YoutubeDataModel>? = null

    override fun toString(): String {
        return "YoutubeResponse(kind=$kind, etag=$etag, prevPageToken=$prevPageToken, nextPageToken=$nextPageToken, regionCode=$regionCode, items=$items)"
    }


}