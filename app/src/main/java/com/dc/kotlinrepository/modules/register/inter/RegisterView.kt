package com.dc.kotlinrepository.modules.register.inter

import com.dc.kotlinrepository.entity.LoginRegisterResponse

interface RegisterView {

    fun registerSuccess(registerBean: LoginRegisterResponse?)

    fun registerFailed(errorMsg: String?)
}