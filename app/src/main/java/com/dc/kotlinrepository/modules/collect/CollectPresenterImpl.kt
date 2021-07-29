package com.dc.kotlinrepository.modules.collect

import com.dc.kotlinrepository.databse.Student
import com.dc.kotlinrepository.modules.collect.inter.CollectModel
import com.dc.kotlinrepository.modules.collect.inter.CollectPresenter
import com.dc.kotlinrepository.modules.collect.inter.CollectView

class CollectPresenterImpl constructor(private var view: CollectView?): CollectPresenter,
    CollectPresenter.OnCollectListener, CollectPresenter.OnCollectResponseListener {

    private val model: CollectModel = CollectModelImpl()

    override fun insert(vararg students: Student) {
        model.insert(this, *students)
    }

    override fun update(vararg students: Student) {
        model.update(this, *students)
    }

    override fun delete(vararg students: Student) {
        model.delete(this, *students)
    }

    override fun deleteAll() {
        model.deleteAll(this)
    }

    override fun queryAll() {
        model.queryAll(this)
    }

    override fun unAttachView() {
        view = null
    }

    override fun showIUD(iudResult: Boolean) {
        view?.showResult(iudResult)
    }

    override fun showResultSuccess(result: List<Student>?) {
        view?.showResultSuccess(result)
    }
}