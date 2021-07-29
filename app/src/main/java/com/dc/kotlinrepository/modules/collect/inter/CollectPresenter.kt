package com.dc.kotlinrepository.modules.collect.inter

import com.dc.kotlinrepository.base.IBasePresenter
import com.dc.kotlinrepository.databse.Student

interface CollectPresenter : IBasePresenter {

    fun insert(vararg students: Student)

    fun update(vararg students: Student)

    fun delete(vararg students: Student)

    fun deleteAll()

    fun queryAll()

    interface OnCollectResponseListener {
        fun showResultSuccess(result: List<Student>?)
    }

    interface OnCollectListener {
        fun showIUD(iudResult: Boolean)
    }
}