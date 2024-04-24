package com.danicode.basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import com.danicode.basic.imc_calculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()

        val btnSayHello = findViewById<Button>(R.id.btnSayHello)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)

        btnSayHello.setOnClickListener { navigateToHello() }
        btnIMCApp.setOnClickListener { navigateIMCApp() }


    }

    private fun navigateIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToHello() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}