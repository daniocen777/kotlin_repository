package com.danicode.basic.superhero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager

import com.danicode.basic.superhero.DetailSuperHeroActivity.Companion.EXTRA_ID
import com.danicode.basic.databinding.ActivitySuperHeroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {
    /**
     * View Binding en lugar findViewByID... => Importar en gradle (Module :app)
     * viewBinding {
    enable = true
    }
     * */
    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit // Para las apis
    private lateinit var superHeroAdapter: SuperHeroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        // setContentView(R.layout.activity_super_hero_list)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        // cuando se haga tap al buscar (setOnQueryTextListener), hacer la llamada a la API
        binding.svSearchHero.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            // Se llama cuando se haga tap al boton
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            // Se llama cuando se vaya escribiendo
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        // Adapter
        superHeroAdapter =
            SuperHeroAdapter { navigateToDetail(it) }// Ya esta inicializado a una lista vacia
        // recycleView
        binding.rvSuperHero.setHasFixedSize(true)
        binding.rvSuperHero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperHero.adapter = superHeroAdapter
    }

    private fun searchByName(query: String) {
        // Cargando
        binding.pbLoadingHeroes.isVisible = true
        // Lanzar una corrutina en hilos (Main, Default, IO, Unconfined)
        // Hilo secundario
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<SuperHeroDataResponse> = retrofit
                .create(IApiService::class.java)
                .getSuperHeroes(query)

            if (response.isSuccessful) {
                // Log.i("Result", "Funciona API")
                val heroesResponse: SuperHeroDataResponse? = response.body()
                if (heroesResponse != null) {
                    // Log.i("Result", heroesResponse.toString())
                    // Se debe correr en el hilo principal, no dentro de la corutina
                    runOnUiThread {
                        superHeroAdapter.updateList(heroesResponse.heroes)
                        binding.pbLoadingHeroes.isVisible = false
                    }

                }
            } else {
                Log.i("Result", "ERROR")
            }
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

    private fun navigateToDetail(id: String) {
        val intent = Intent(this, DetailSuperHeroActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }
}