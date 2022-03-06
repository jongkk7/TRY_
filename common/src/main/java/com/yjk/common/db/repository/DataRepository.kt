package com.yjk.common.db.repository

import android.content.Context
import androidx.room.RoomDatabase
import com.yjk.common.db.AppDatabase
import com.yjk.common.db.dao.UserDao
import com.yjk.common.db.dao.YoutubeSearchDao
import com.yjk.common.util.TLog

class DataRepository(val context: Context) {

    lateinit var db: RoomDatabase.Builder<AppDatabase>
    lateinit var userDao: UserDao
    lateinit var youtubeSearchDao: YoutubeSearchDao

    init {
//        val db = DatabaseHelper.getDatabase(context)
        val db = AppDatabase.getInstance()
        userDao = db.userDao()
        youtubeSearchDao = db.youtubeSearchDao()
    }

}