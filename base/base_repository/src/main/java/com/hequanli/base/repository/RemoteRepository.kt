package com.hequanli.base.repository

import com.hequanli.base.http.RetrofitFactory
import com.hequanli.base.http.utils.RxUtils
import com.hequanli.base.repository.home.HomeService
import io.reactivex.rxjava3.core.Observable

/**
 * @author HQL
 * Created on 2021/11/22
 * Desc:
 */

class RemoteRepository {

    private val homeService: HomeService = RetrofitFactory.instance.create(HomeService::class.java)

    companion object {
        val me: RemoteRepository by lazy(RemoteRepository::class.java) {
            RemoteRepository()
        }
    }

    fun getHomeArticleList(): Observable<String> {
        return homeService.getHomeArticleList()
            .map(BaseResponseRxMapper())
            .compose(RxUtils.ioToMain())
    }
}