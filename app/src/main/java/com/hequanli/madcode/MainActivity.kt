package com.hequanli.madcode

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.textView).setOnClickListener {
            testClick()
        }
    }

    private fun testClick() {
        for (index in 0..100000000) {
            if (index == 99999999) {
                Toast.makeText(this, "XXXXXXX", Toast.LENGTH_LONG).show()
            }
        }
    }
}