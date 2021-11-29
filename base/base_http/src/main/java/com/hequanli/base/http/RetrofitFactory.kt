package com.hequanli.base.http

import com.hequanli.base.http.converter.gson.GsonConverterFactory
import com.hequanli.base.http.interceptor.CommonInterceptor
import com.hequanli.base.http.interceptor.LoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import java.util.concurrent.TimeUnit

/**
 * @author HQL
 * Created on 2021/6/22
 * Desc:
 */

class RetrofitFactory private constructor() {

    private val retrofit: Retrofit
    private val defaultTimeout = 30L //超时时间
    private val defaultReadTimeout = 30L //读取时间
    private val defaultWriteTimeout = 30L //读取时间

    init {

        val okhttp = OkHttpClient().newBuilder().apply {
            connectTimeout(defaultTimeout, TimeUnit.SECONDS)
            readTimeout(defaultReadTimeout, TimeUnit.SECONDS)
            writeTimeout(defaultWriteTimeout, TimeUnit.SECONDS)
            addInterceptor(LoggingInterceptor.Builder().build())
            addInterceptor(CommonInterceptor())
        }.build()

        retrofit = Retrofit.Builder().apply {
            baseUrl("https://www.wanandroid.com")
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            client(okhttp)
        }.build()
    }

    companion object {
        val instance by lazy {
            RetrofitFactory()
        }
    }

    fun <T> create(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}