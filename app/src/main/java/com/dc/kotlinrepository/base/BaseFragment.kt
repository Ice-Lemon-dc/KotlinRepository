package com.dc.kotlinrepository.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseFragment<P : IBasePresenter> : Fragment() {

    lateinit var presenter : P
    private lateinit var mActivity: AppCompatActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = getPresent()
    }

    abstract fun getPresent(): P

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createOk()
    }

    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }

    abstract fun createOk()

    abstract fun recycle()


}