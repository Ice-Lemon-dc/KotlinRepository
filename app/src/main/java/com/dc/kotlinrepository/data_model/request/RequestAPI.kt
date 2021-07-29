package com.dc.kotlinrepository.data_model.request

import com.xiangxue.kotlinproject.config.Flag
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request

object RequestAPI {

    fun instanceRequest(url: String, resultData: NetworkResultData, vararg values: String) {
        val okHttpClient = OkHttpClient()

        val builder: MultipartBody.Builder = MultipartBody.Builder()
            .setType(MultipartBody.FORM)
        for (value in values) {
            builder.addFormDataPart(Flag.PART, value)
        }
        val request: Request = Request.Builder()
            .url(url)
            .post(builder.build()).build()

        okHttpClient.newCall(request).enqueue(resultData)
    }
}