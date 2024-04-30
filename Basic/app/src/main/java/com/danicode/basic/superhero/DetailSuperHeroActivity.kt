package com.danicode.basic.superhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import com.danicode.basic.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailSuperHeroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extraID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_super_hero)
        // Recuperar ID
        val imdbID: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperHeroDetail(imdbID)
    }

    private fun getSuperHeroDetail(iD: Any) {
        CoroutineScope(Dispatchers.IO).launch {
           
        }
    }

    // Para el consumo de apis, se necesita retrofit (ver gradle (Modulo :app)
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("http://www.omdbapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
