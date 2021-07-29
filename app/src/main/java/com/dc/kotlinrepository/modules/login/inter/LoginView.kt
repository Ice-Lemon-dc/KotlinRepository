package com.dc.kotlinrepository.modules.login.inter

import com.dc.kotlinrepository.entity.LoginRegisterResponse

/**
 * View层
 */
interface LoginView {

    fun loginSuccess(loginBean: LoginRegisterResponse?)

    fun loginFailure(errorMsg: String?)
}