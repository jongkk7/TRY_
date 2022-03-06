package com.yjk.common.http.datamodel.youtube

data class YoutubeDataModel(
    val etag: String,
    val kind: String,
    val Id: Id,
    val snippet: Snippet,
    val statistics: Statistics
)