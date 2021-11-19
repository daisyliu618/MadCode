package com.hequanli.base.http.response

/**
 * @author HQL
 * Created on 2021/11/5
 * Desc:
 */

open class BaseResponse<T>(var data: T, var code: Int = -1, var msg: String = "")