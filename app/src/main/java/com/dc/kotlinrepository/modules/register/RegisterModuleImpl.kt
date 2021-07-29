package com.dc.kotlinrepository.modules.register

import android.content.Context
import com.dc.kotlinrepository.api.WanAndroidApi
import com.dc.kotlinrepository.entity.LoginRegisterResponse
import com.dc.kotlinrepository.modules.register.inter.RegisterModule
import com.dc.kotlinrepository.modules.register.inter.RegisterPresenter
import com.dc.kotlinrepository.net.ApiClient
import com.dc.kotlinrepository.net.ApiResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RegisterModuleImpl: RegisterModule {

    override fun cancelRequest() {

    }

    override fun register(
        context: Context,
        username: String,
        password: String,
        repassword: String,
        callback: RegisterPresenter.OnRegisterListener
    ) {
        ApiClient.instanceRetrofit(WanAndroidApi::class.java)
            .register(username, password, repassword)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiResponse<LoginRegisterResponse>(context) {
                override fun success(data: LoginRegisterResponse?) {
                    callback.registerSuccess(data)
                }

                override fun failure(errorMsg: String?) {
                    callback.registerFailed(errorMsg)
                }

            })
    }


}