package com.dc.kotlinrepository.entity

data class LoginRegisterResponseWrapper<T>(val data: T, val errorCode: Int, val errorMsg: String)
