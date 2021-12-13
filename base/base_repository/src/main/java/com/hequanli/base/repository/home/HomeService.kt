package com.hequanli.base.repository.home

import com.hequanli.base.http.response.BaseResponse
import com.hequanli.base.http.utils.HttpConstant
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * @author HQL
 * Created on 2021/11/22
 * Desc:
 */

interface HomeService {

    @Headers(HttpConstant.BASE_DOMAIN)
    @GET("article/list/0/json")
    fun getHomeArticleList(): Observable<BaseResponse<String>>

}