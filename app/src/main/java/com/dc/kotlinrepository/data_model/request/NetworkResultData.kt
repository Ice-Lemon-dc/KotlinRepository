package com.dc.kotlinrepository.data_model.request

import android.util.Log
import com.dc.kotlinrepository.util.ThreadUtil
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

abstract class NetworkResultData : Callback {

    override fun onFailure(call: Call, e: IOException) {
        ThreadUtil.runMainThread {
            e.message?.let { requestFailure(it) }
        }
    }

    override fun onResponse(call: Call, response: Response) {
        Log.e("---===", "onResponse:" + ThreadUtil.isMainThread())
        ThreadUtil.runMainThread {
            Log.e("---===", "runMainThread:" + ThreadUtil.isMainThread())
            requestSuccess(response)
        }
    }

    abstract fun requestFailure(info: String)

    abstract fun requestSuccess(result: Response)
}