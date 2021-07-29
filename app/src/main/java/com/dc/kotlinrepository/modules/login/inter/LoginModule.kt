package com.dc.kotlinrepository.modules.login.inter

import android.content.Context

interface LoginModule {

    fun cancelRequest()

    fun login(context: Context, userName: String, password: String, listener: LoginPresenter.OnLoginListener)
}