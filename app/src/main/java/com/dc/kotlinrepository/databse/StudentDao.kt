package com.dc.kotlinrepository.databse

import androidx.room.*

@Dao
interface StudentDao {

    @Insert
    fun insertStudents(vararg students: Student)

    @Update
    fun updateStudents(vararg students: Student)

    @Delete
    fun deleteStudents(vararg students: Student)

    @Query("DELETE FROM student")
    fun deleteAllStudents()

    @Query("SELECT * FROM student ORDER BY ID DESC")
    fun queryAllStudents(): List<Student>
}