package com.dc.kotlinrepository

import android.app.Application
import com.dc.kotlinrepository.databse.StudentDatabase

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        StudentDatabase.getDatabase(this)
    }
}