package com.dev.topefirstapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler()
        handler.postDelayed({
            val mInHome = Intent(this@MainActivity, DashboardActivity::class.java)
            this@MainActivity.startActivity(mInHome)
            this@MainActivity.finish()
        }, 3000)

    }
}