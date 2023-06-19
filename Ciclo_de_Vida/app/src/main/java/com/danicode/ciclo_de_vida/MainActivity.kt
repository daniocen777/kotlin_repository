package com.danicode.ciclo_de_vida

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    // Para reproducir sonido
    private var mediaPlayer: MediaPlayer? = null
    private var position: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i("Ciclo de Vida", "onCreate")
        // Botón
        findViewById<MaterialButton>(R.id.btnCheck).setOnClickListener {
            startActivity(Intent(this, DialogActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("Ciclo de Vida", "onStart")
        // Inicializar
        mediaPlayer = MediaPlayer.create(this, R.raw.ai_2)

    }

    // Consultas a la BD
    override fun onResume() {
        super.onResume()
        Log.i("Ciclo de Vida", "onResume")
        // Reproducir
        mediaPlayer?.seekTo(position) // para reproducir sonido desde donde se detuvo
        mediaPlayer?.start() // Ver imagen de ciclo de vida
    }

    override fun onPause() {
        super.onPause()
        Log.i("Ciclo de Vida", "onPause")
        mediaPlayer?.pause()
        // Guardar el progreso del sonido
        if (mediaPlayer != null) {
            position = mediaPlayer!!.currentPosition
        }
    }

    // Para liberar los recursos
    override fun onStop() {
        super.onStop()
        Log.i("Ciclo de Vida", "onStop")
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Ciclo de Vida", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Ciclo de Vida", "onDestroy")
    }
}