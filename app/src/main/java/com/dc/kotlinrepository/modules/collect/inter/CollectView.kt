package com.dc.kotlinrepository.modules.collect.inter

import com.dc.kotlinrepository.databse.Student

interface CollectView {

    fun showResultSuccess(result: List<Student>?)

    fun showResult(result: Boolean)
}