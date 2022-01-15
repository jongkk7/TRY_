package com.yjk.atry._101_room.dao

import androidx.room.*
import com.yjk.atry._101_room.datamodel.UserDataModel

@Dao
interface UserDao{

    @Query("SELECT * FROM userdatamodel")
    fun getAll(): List<UserDataModel>

    @Query("SELECT * FROM UserDataModel WHERE id IN (:id)")
    fun getUser(id: String): UserDataModel

    @Insert
    fun insertAll(vararg users: UserDataModel)

    @Insert
    fun insert(user: UserDataModel)

    @Update
    fun updateUsers(vararg users : UserDataModel)

    @Update
    fun update(user : UserDataModel)

    @Delete
    fun delete(user: UserDataModel)

    @Delete
    fun deleteUser(vararg user: UserDataModel)

}