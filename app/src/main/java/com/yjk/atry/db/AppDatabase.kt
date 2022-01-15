package com.yjk.atry.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yjk.atry._101_room.dao.UserDao
import com.yjk.atry._101_room.datamodel.ADataModel
import com.yjk.atry._101_room.datamodel.UserDataModel
import com.yjk.atry.db.dao.TestDao
import com.yjk.atry.db.datamodel.TestDataModel

/**
 * Room Database
 * DataModel 추가 시 entities에 클래스 추가
 * DAO 반환 함수 추가
 * 버전 + 1
 */
@Database(entities = arrayOf(UserDataModel::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun testDao(): TestDao

    // todo DAO 추가


    /**
     * Application 단에서 createInstance 호출할 것!
     */
    companion object {

        private var INSTANCE: AppDatabase? = null

        public fun createInstance(context: Context) {

            if (INSTANCE == null) {

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
        }

        public fun getInstance(): AppDatabase? {
            return INSTANCE
        }

        public fun destroyInstance() {
            INSTANCE = null
        }
    }

}