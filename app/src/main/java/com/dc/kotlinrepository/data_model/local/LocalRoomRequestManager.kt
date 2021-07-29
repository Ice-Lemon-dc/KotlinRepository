package com.dc.kotlinrepository.data_model.local

import com.dc.kotlinrepository.databse.Student
import com.dc.kotlinrepository.databse.StudentDao
import com.dc.kotlinrepository.databse.StudentDatabase

object LocalRoomRequestManager {

    var studentDao: StudentDao? = null

    init {
        val studentDatabase: StudentDatabase? = StudentDatabase.getDatabase()
        studentDao = studentDatabase?.getStudentDao()
    }

    fun insertStudents(vararg students: Student) {
        studentDao?.insertStudents(*students)
    }

    fun updateStudents(vararg students: Student) {
        studentDao?.updateStudents(*students)
    }

    fun deleteStudents(vararg students: Student) {
        studentDao?.deleteStudents(*students)
    }

    fun deleteAllStudent() {
        studentDao?.deleteAllStudents()
    }

    fun queryAllStudent() : List<Student>? {
        return studentDao?.queryAllStudents()
    }
}