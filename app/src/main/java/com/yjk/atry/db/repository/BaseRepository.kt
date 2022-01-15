package com.yjk.atry.db.repository

import android.content.Context
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.RoomDatabase
import com.yjk.atry.db.AppDatabase
import com.yjk.atry.db.dao.BaseDao

/**
 * 내부 DB
 * find
 * insert
 * update
 * delete
 */
abstract class BaseRepository<D : Dao, E>(val context : Context) {



}