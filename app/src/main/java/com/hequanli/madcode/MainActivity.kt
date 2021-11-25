package com.hequanli.madcode

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.hequanli.base.http.response.BaseResponse
import com.hequanli.base.repository.RemoteRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RemoteRepository.me.getHomeArticleList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableObserver<BaseResponse<String>>() {
                override fun onNext(t: BaseResponse<String>?) {
                    Log.d("XXX", "onNext")
                }

                override fun onError(e: Throwable?) {
                    Log.d("XXX", "onError")
                }

                override fun onComplete() {
                    Log.d("XXX", "onComplete")
                }
            })
    }
}