package com.hequanli.base.repository

import com.hequanli.base.http.RetrofitFactory
import com.hequanli.base.http.mapper.BaseResponseRxMapper
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

    /**
    /*
     * **/
    public static void getDuoBanTop(int start, int count, Observer<movieTopReq> observer) {
             setSubscribe(movieService.getMovicTop(start, count), observer);
    }

    private static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
            observable.subscribeOn(Schedulers.io())
            .subscribeOn(Schedulers.newThread())//子线程访问网络
            .observeOn(AndroidSchedulers.mainThread())//回调到主线程
            .subscribe(observer);
    }
     */
}