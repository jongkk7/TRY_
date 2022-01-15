package com.yjk.atry._101_room.repository

import android.content.Context
import androidx.room.RoomDatabase
import com.yjk.atry._101_room.dao.UserDao
import com.yjk.atry._101_room.datamodel.UserDataModel
import com.yjk.atry.db.AppDatabase
import com.yjk.atry.db.repository.DatabaseHelper
import com.yjk.common.util.TLog

class UserRepository (val context : Context){

    lateinit var db : RoomDatabase.Builder<AppDatabase>
    lateinit var userDao : UserDao

    init{
        val db = DatabaseHelper.getDatabase(context)
        userDao = db.build().userDao()
    }

    suspend fun getUserList() : List<UserDataModel>{
        val userList = userDao.getAll()
        TLog.d("user list: $userList")
        return userList
    }

    suspend fun insertUser(user : UserDataModel){
        userDao.insert(user)
    }

    fun updateUser(user : UserDataModel){
        userDao.update(user)
    }

    fun deleteUser(user : UserDataModel){
        userDao.delete(user)
    }
}