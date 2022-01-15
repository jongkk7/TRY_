package com.yjk.atry.db.datamodel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yjk.atry.db.dao.BaseDao
import java.lang.reflect.ParameterizedType

/**
 * 테스트용 데이터 모델
 */
@Entity ( tableName = BaseDataModel.TABLE_NAME)
abstract class TestDataModel(id : String){

    /**
     * TABLE NAME 재 정의 필수
     */
    companion object {
        const val TABLE_NAME = "test"
    }

}