package com.hequanli.madcode

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hequanli.base.http.mapper.BaseObserver
import com.hequanli.base.repository.RemoteRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RemoteRepository.me.getHomeArticleList()
            .subscribeWith(object : BaseObserver<String>() {
                override fun succeed(t: String) {
                }

                override fun error(msg: String?, code: Int?) {
                    Toast.makeText(this@MainActivity, msg + code, Toast.LENGTH_LONG).show()
                }
            })
    }
}