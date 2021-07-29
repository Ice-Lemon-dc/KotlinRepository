package com.dc.kotlinrepository.modules.login

import android.content.Context
import com.dc.kotlinrepository.entity.LoginRegisterResponse
import com.dc.kotlinrepository.modules.login.inter.LoginPresenter
import com.dc.kotlinrepository.modules.login.inter.LoginView

class LoginPresenterImpl(var loginView: LoginView?) : LoginPresenter,
    LoginPresenter.OnLoginListener {

    private val loginModel : LoginModuleImpl = LoginModuleImpl()

    override fun login(context: Context, userName: String, password: String) {
        loginModel.login(context, userName, password, this)
    }

    override fun unAttachView() {
        loginView = null
        loginModel.cancelRequest()
    }

    override fun loginSuccess(loginBean: LoginRegisterResponse?) {
        loginView?.loginSuccess(loginBean)
    }

    override fun loginFailure(errorMsg: String?) {
        loginView?.loginFailure(errorMsg)
    }
}