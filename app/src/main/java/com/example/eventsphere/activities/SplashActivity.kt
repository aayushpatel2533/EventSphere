package com.example.eventsphere.activities


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.eventsphere.R
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val auth = FirebaseAuth.getInstance()
        val next = if (auth.currentUser != null) MainActivity::class.java else LoginActivity::class.java
        window.decorView.postDelayed({
            startActivity(Intent(this, next))
            finish()
        }, 1800)
    }
}