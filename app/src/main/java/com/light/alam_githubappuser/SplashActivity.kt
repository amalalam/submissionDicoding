package com.light.alam_githubappuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lets_start.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val letStart = Intent(this, MainActivity::class.java)
        startActivity(letStart)
    }
}