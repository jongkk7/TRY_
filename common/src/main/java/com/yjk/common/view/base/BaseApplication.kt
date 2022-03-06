package com.yjk.common.view.base

import android.app.Application
import com.yjk.common.db.AppDatabase

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        AppDatabase.createInstance(this)

    }



}