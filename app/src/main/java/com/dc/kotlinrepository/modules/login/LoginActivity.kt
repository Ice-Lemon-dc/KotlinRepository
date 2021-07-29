package com.dc.kotlinrepository.modules.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dc.kotlinrepository.MainActivity
import com.dc.kotlinrepository.R
import com.dc.kotlinrepository.base.BaseActivity
import com.dc.kotlinrepository.entity.LoginRegisterResponse
import com.dc.kotlinrepository.modules.login.inter.LoginPresenter
import com.dc.kotlinrepository.modules.login.inter.LoginView
import kotlinx.android.synthetic.main.activity_user_login.*

class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        user_login_bt.setOnClickListener(onClickListener)
    }

    private val onClickListener = View.OnClickListener { view ->
        when(view.id) {
            R.id.user_login_bt -> {
                val userName = user_phone_et.text.toString()
                val userPwd = user_password_et.text.toString()
                presenter.login(this, userName, userPwd)
            }
        }
    }

    override fun createP(): LoginPresenter = LoginPresenterImpl(this)

    override fun recycle() {
        presenter.unAttachView()
    }

    override fun loginSuccess(loginBean: LoginRegisterResponse?) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun loginFailure(errorMsg: String?) {
        Toast.makeText(this@LoginActivity, "登录失败", Toast.LENGTH_SHORT).show()
    }
}