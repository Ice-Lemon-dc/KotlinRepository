package com.dc.kotlinrepository.net

import android.content.Context
import com.dc.kotlinrepository.entity.LoginRegisterResponseWrapper
import com.dc.kotlinrepository.view.LoadingDialog
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

abstract class ApiResponse<T>(private val context: Context) : Observer<LoginRegisterResponseWrapper<T>> {

    private var isShow: Boolean = true

    constructor(context: Context, isShow: Boolean = false) : this(context) {
        this.isShow = isShow
    }

    abstract fun success(data: T?)

    abstract fun failure(errorMsg: String?)

    override fun onSubscribe(d: Disposable) {
        if (isShow) {
            LoadingDialog.show(context)
        }
    }

    override fun onNext(t: LoginRegisterResponseWrapper<T>) {
        if (t.data == null) {
            failure("登录失败了，请检查原因：msg:${t.errorMsg}")
        } else {
            success(t.data)
        }
    }

    override fun onError(e: Throwable) {
        LoadingDialog.cancel()
        failure(e.message)
    }

    override fun onComplete() {
        LoadingDialog.cancel()
    }
}