package com.dc.kotlinrepository.modules.register.inter

import android.content.Context

interface RegisterModule {

    fun cancelRequest()

    fun register(context: Context, username: String, password: String, repassword: String, callback: RegisterPresenter.OnRegisterListener)
}