package com.hequanli.base.http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author HQL
 * Created on 2021/6/22
 * Desc:
 */
class RetrofitFactory private constructor() {

    private val retrofit: Retrofit

    private val DEFAULT_TIME_OUT = 60L //超时时间
    private val DEFAULT_READ_TIME_OUT = 60L //读取时间
    private val DEFAULT_WRITE_TIME_OUT = 60L //读取时间

    init {
        retrofit = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .client(initOkHttpClient())
            .build()
    }

    companion object {
        val instance by lazy {
            RetrofitFactory()
        }
    }

    private fun initOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder()
            .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_WRITE_TIME_OUT, TimeUnit.SECONDS)
            .build()
    }

    fun <T> create(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}