package com.yjk.common.db.dao

import androidx.room.*
import com.yjk.common.db.datamodel.UserDataModel

@Dao
interface UserDao{

    @Query("SELECT * FROM userdatamodel")
    fun selectAll(): List<UserDataModel>

    @Query("SELECT * FROM UserDataModel WHERE id IN (:id)")
    fun select(id: String): UserDataModel

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