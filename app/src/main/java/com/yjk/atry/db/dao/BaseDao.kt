package com.yjk.atry.db.dao

import androidx.room.*
import androidx.sqlite.db.SimpleSQLiteQuery
import androidx.sqlite.db.SupportSQLiteQuery
import java.lang.reflect.ParameterizedType


@Dao
abstract class BaseDao <T>{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(data: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(vararg dataList: T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(data : T)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    abstract fun update(vararg dataList : T)

    @Delete
    abstract fun delete(data: T)

    @Delete
    abstract fun delete(vararg dataList: T)

    public fun find(id: Long): T {
        val query = SimpleSQLiteQuery(
            "select * from " + getTableName() + " where id = ?",
            arrayOf<Any>(id)
        )
        return doFind(query)
    }

    public fun findAll() : List<T>{
        val query = SimpleSQLiteQuery("select * from " + getTableName())
        return doFindAll(query)
    }

    fun deleteAll(): Int {
        val query = SimpleSQLiteQuery(
            "delete from " + getTableName()
        )
        return doDeleteAll(query)
    }

    @RawQuery
    protected abstract fun doFindAll(query: SupportSQLiteQuery): List<T>

    @RawQuery
    protected abstract fun doFind(query: SupportSQLiteQuery): T

    @RawQuery
    protected abstract fun doDeleteAll(query: SupportSQLiteQuery?): Int

    fun getTableName(): String {
        val clazz = (javaClass.superclass.genericSuperclass as ParameterizedType)
            .actualTypeArguments[0] as Class<*>
        return clazz.simpleName
    }
}