package com.yjk.common.http.datamodel.youtube

data class Statistics(
    val hiddenSubscriberCount: Boolean,
    val subscriberCount: String,
    val videoCount: String,
    val viewCount: String
)