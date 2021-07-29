package com.dc.kotlinrepository.api

import com.dc.kotlinrepository.entity.LoginRegisterResponse
import com.dc.kotlinrepository.entity.LoginRegisterResponseWrapper
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface WanAndroidApi {


    @FormUrlEncoded
    @POST("/user/login")
    fun login(@Field("username") username: String, @Field("password") password: String) : Observable<LoginRegisterResponseWrapper<LoginRegisterResponse>>

    @FormUrlEncoded
    @POST("/user/register")
    fun register(@Field("username") username: String, @Field("password")password: String, @Field("repassword") repassword: String): Observable<LoginRegisterResponseWrapper<LoginRegisterResponse>>
}