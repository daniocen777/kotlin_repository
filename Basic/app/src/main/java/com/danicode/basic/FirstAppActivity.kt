package com.danicode.basic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)

        val btnHello = findViewById<AppCompatButton>(R.id.btnHello)
        val etHello = findViewById<AppCompatEditText>(R.id.etHello)

        btnHello.setOnClickListener {
            val valueEditText = etHello.text.toString()
            if (valueEditText.isNotEmpty()) {
                // Intent(context, adonde ir)
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_VALUE", valueEditText)
                startActivity(intent)
            }
        }
    }
}