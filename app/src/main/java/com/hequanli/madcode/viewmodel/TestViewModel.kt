package com.hequanli.madcode.viewmodel

import androidx.lifecycle.ViewModel
import com.hequanli.base.repository.RemoteRepository

/**
 * @author HQL
 * Created on 2021/11/29
 * Desc:
 */
class TestViewModel : ViewModel() {



    fun getHomeArticleList() {
        RemoteRepository.me.getHomeArticleList().subscribe {

        }
    }
}