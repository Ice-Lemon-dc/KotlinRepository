package com.dc.kotlinrepository.modules.register

import android.os.Bundle
import android.widget.Toast
import com.dc.kotlinrepository.R
import com.dc.kotlinrepository.base.BaseActivity
import com.dc.kotlinrepository.entity.LoginRegisterResponse
import com.dc.kotlinrepository.modules.register.inter.RegisterPresenter
import com.dc.kotlinrepository.modules.register.inter.RegisterView
import kotlinx.android.synthetic.main.activity_user_register.*

class RegisterActivity : BaseActivity<RegisterPresenter>(), RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)

        user_register_bt.setOnClickListener {
            val username = user_phone_et.text.toString()
            val password = user_password_et.text.toString()
            presenter.register(this, username, password, password)
        }
    }

    override fun createP(): RegisterPresenter = RegisterPresenterImpl(this)

    override fun recycle() {

    }

    override fun registerSuccess(registerBean: LoginRegisterResponse?) {
        Toast.makeText(this, "注册成功😀", Toast.LENGTH_SHORT).show()
    }

    override fun registerFailed(errorMsg: String?) {
        Toast.makeText(this, "注册失败 ~ 呜呜呜", Toast.LENGTH_SHORT).show()
    }
}