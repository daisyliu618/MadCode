package com.hequanli.madcode

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.hequanli.base.repository.RemoteRepository
import io.reactivex.rxjava3.observers.DisposableObserver

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RemoteRepository.me.getHomeArticleList()
            .subscribeWith(object : DisposableObserver<String>() {
                override fun onNext(t: String?) {
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