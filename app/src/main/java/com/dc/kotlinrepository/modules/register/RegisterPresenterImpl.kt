package com.dc.kotlinrepository.modules.register

import android.content.Context
import com.dc.kotlinrepository.entity.LoginRegisterResponse
import com.dc.kotlinrepository.modules.register.inter.RegisterPresenter
import com.dc.kotlinrepository.modules.register.inter.RegisterView

class RegisterPresenterImpl constructor(var view: RegisterView?): RegisterPresenter,
    RegisterPresenter.OnRegisterListener {

    private val model = RegisterModuleImpl();

    override fun register(
        context: Context,
        username: String,
        password: String,
        repasswrod: String
    ) {
        model.register(context, username, password, repasswrod, this)
    }

    override fun unAttachView() {
        view = null
        model.cancelRequest()
    }

    override fun registerSuccess(registerBean: LoginRegisterResponse?) {
        view?.registerSuccess(registerBean)
    }

    override fun registerFailed(errorMsg: String?) {
        view?.registerFailed(errorMsg)
    }
}