package com.hequanli.base.http.mapper

import com.hequanli.base.http.exception.ServerException
import com.hequanli.base.http.response.BaseResponse
import io.reactivex.rxjava3.functions.Function

/**
 * @author HQL
 * Created on 2021/11/26
 * Desc:
 */

class BaseResponseRxMapper<T> : Function<BaseResponse<T>, T> {

    override fun apply(t: BaseResponse<T>): T {
        if (t.isSuccess()) {
            return t.data
        }
        throw ServerException(t.errorMsg, t.errorCode)
    }
}