package com.danicode.virtualstore

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        viewWelcome()

    }

    // CountDownTimer => ejecutar codigo luego de cirto tiempo
    private fun viewWelcome() {
        // 3 2 1
        object : CountDownTimer(3000, 1000) {
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                // Ir al manifest para que sea Splash la 1° vista
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finishAffinity() // destruir splash
            }
        }.start()
    }
}