package com.dc.kotlinrepository.modules.login.inter

import android.content.Context
import com.dc.kotlinrepository.base.IBasePresenter
import com.dc.kotlinrepository.entity.LoginRegisterResponse

interface LoginPresenter : IBasePresenter{

    fun login(context: Context, userName: String, password: String)

    interface OnLoginListener {

        fun loginSuccess(loginBean: LoginRegisterResponse?)

        fun loginFailure(errorMsg: String?)
    }
}