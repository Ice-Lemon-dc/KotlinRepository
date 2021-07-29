package com.dc.kotlinrepository.modules.register.inter

import android.content.Context
import com.dc.kotlinrepository.base.IBasePresenter
import com.dc.kotlinrepository.entity.LoginRegisterResponse

interface RegisterPresenter : IBasePresenter {

    fun register(context: Context, username: String, password: String, repasswrod: String)

    interface OnRegisterListener {

        fun registerSuccess(registerBean: LoginRegisterResponse?)

        fun registerFailed(errorMsg: String?)
    }
}