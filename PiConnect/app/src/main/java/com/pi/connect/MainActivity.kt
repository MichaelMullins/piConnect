package com.pi.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, createConnectFragment())
            .commit()

        val piService by lazy { buildPiApiService() }

        val fa= piService.getBaseUrl()
            .raw()
        Log.d("ApiService", "$fa")
    }
}
