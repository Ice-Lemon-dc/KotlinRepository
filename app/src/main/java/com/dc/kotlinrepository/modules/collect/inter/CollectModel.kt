package com.dc.kotlinrepository.modules.collect.inter

import com.dc.kotlinrepository.databse.Student

interface CollectModel {

    fun insert(listener: CollectPresenter.OnCollectListener, vararg students: Student)

    fun update(listener: CollectPresenter.OnCollectListener, vararg students: Student)

    fun delete(listener: CollectPresenter.OnCollectListener, vararg students: Student)

    fun deleteAll(listener: CollectPresenter.OnCollectListener)

    fun queryAll(listener: CollectPresenter.OnCollectResponseListener)
}