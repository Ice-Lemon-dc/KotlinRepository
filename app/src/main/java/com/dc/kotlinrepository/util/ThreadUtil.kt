package com.dc.kotlinrepository.util

import android.os.Looper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object ThreadUtil {

    fun isMainThread(): Boolean = Looper.myLooper() == Looper.getMainLooper()

    fun runMainThread(runnable: Runnable) {
        if (isMainThread()) {
            runnable.run()
        } else {
            AndroidSchedulers.mainThread().scheduleDirect(runnable)
        }
    }

    fun runIoThread(runnable: Runnable) {
        if (isMainThread()) {
            Schedulers.io().scheduleDirect(runnable)
        } else{
            runnable.run()
        }
    }
}