package com.pi.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = supportFragmentManager.findFragmentByTag(CONNECT_FRAGMENT_TAG)
        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .show(fragment)
        } else {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, createConnectFragment(), CONNECT_FRAGMENT_TAG)
                .commit()
        }

    }


}
