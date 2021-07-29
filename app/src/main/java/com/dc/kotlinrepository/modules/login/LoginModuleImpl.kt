package com.dc.kotlinrepository.modules.login

import android.content.Context
import com.dc.kotlinrepository.api.WanAndroidApi
import com.dc.kotlinrepository.entity.LoginRegisterResponse
import com.dc.kotlinrepository.modules.login.inter.LoginModule
import com.dc.kotlinrepository.modules.login.inter.LoginPresenter
import com.dc.kotlinrepository.net.ApiClient
import com.dc.kotlinrepository.net.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginModuleImpl : LoginModule {

    override fun cancelRequest() {

    }

    override fun login(
        context: Context,
        userName: String,
        password: String,
        listener: LoginPresenter.OnLoginListener
    ) {
        ApiClient.instanceRetrofit(WanAndroidApi::class.java)
            .login(userName, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiResponse<LoginRegisterResponse>(context) {
                override fun success(data: LoginRegisterResponse?) {
                    listener.loginSuccess(data)
                }

                override fun failure(errorMsg: String?) {
                    listener.loginFailure(errorMsg)
                }

            })
    }
}