package com.yjk.common.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yjk.common.db.dao.UserDao
import com.yjk.common.db.dao.YoutubeSearchDao
import com.yjk.common.db.datamodel.UserDataModel
import com.yjk.common.db.datamodel.YoutubeSearchDataModel

/**
 * Room Database
 * DataModel 추가 시 entities에 클래스 추가
 * DAO 반환 함수 추가
 * 버전 + 1
 */
@Database(entities = arrayOf(UserDataModel::class, YoutubeSearchDataModel::class), version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun youtubeSearchDao(): YoutubeSearchDao

    // todo DAO 추가


    /**
     * Application 단에서 createInstance 호출할 것!
     */
    companion object {

        private lateinit var INSTANCE: AppDatabase

        fun createInstance(context: Context) {

            synchronized(AppDatabase::class) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "try_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }

        }

        fun getInstance(): AppDatabase {
            return INSTANCE
        }

    }

}