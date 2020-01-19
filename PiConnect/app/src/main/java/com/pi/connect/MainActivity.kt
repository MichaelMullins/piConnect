package com.pi.connect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pi.connect.setup.SET_UP_FRAGMENT_TAG
import com.pi.connect.setup.createSetUpFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.main_fragment_container,
                createSetUpFragment(),
                SET_UP_FRAGMENT_TAG
            )
            .commit()
    }
}
