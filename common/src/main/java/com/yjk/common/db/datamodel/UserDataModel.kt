package com.yjk.common.db.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDataModel(@PrimaryKey val id : Int, val name : String, val tel : String)