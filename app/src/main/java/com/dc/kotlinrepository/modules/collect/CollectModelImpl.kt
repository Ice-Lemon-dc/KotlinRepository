package com.dc.kotlinrepository.modules.collect

import com.dc.kotlinrepository.data_model.local.LocalRoomRequestManager
import com.dc.kotlinrepository.databse.Student
import com.dc.kotlinrepository.modules.collect.inter.CollectModel
import com.dc.kotlinrepository.modules.collect.inter.CollectPresenter

class CollectModelImpl : CollectModel{
    override fun insert(
        listener: CollectPresenter.OnCollectListener,
        vararg students: Student
    ) {
        LocalRoomRequestManager.insertStudents(*students)
        listener.showIUD(true)
    }

    override fun update(
        listener: CollectPresenter.OnCollectListener,
        vararg students: Student
    ) {
        LocalRoomRequestManager.updateStudents(*students)
        listener.showIUD(true)
    }

    override fun delete(
        listener: CollectPresenter.OnCollectListener,
        vararg students: Student
    ) {
        LocalRoomRequestManager.deleteStudents(*students)
        listener.showIUD(true)
    }

    override fun deleteAll(listener: CollectPresenter.OnCollectListener) {
        LocalRoomRequestManager.deleteAllStudent()
        listener.showIUD(true)
    }

    override fun queryAll(listener: CollectPresenter.OnCollectResponseListener) {
        val result = LocalRoomRequestManager.queryAllStudent()
        listener.showResultSuccess(result)
    }
}