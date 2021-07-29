package com.dc.kotlinrepository.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// P extends LoginPresenter                     vs     P: LoginPresenter
// P extends LoginPresenter & Serializable      vs     where P : IBasePresenter,  P: Serializable
abstract class BaseActivity<P> : AppCompatActivity() where P : IBasePresenter{

    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = createP()
    }

    abstract fun createP(): P

    abstract fun recycle()

    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }
}