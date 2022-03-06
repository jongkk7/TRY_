package com.yjk.common.http.datamodel.youtube

data class YoutubeChannelDataModel(
    val etag: String,
    val kind: String,
    val id: String,
    val snippet: Snippet,
    val statistics: Statistics
)