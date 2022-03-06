package com.yjk.common.db.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class YoutubeSearchDataModel(
    @PrimaryKey val searchWord: String,
    val videoId: String,
    val thumbnail: String
)