package com.danicode.basic.superhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.core.view.isVisible
import com.danicode.basic.R
import com.danicode.basic.databinding.ActivityDetailSuperHeroBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class DetailSuperHeroActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extraID"
    }

    private lateinit var mBinding: ActivityDetailSuperHeroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_super_hero)
        mBinding = ActivityDetailSuperHeroBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        // Recuperar ID
        val imdbID: String = intent.getStringExtra(EXTRA_ID).orEmpty()
        getSuperHeroDetail(imdbID)
    }

    private fun getSuperHeroDetail(imdbID: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response =
                getRetrofit().create(IApiService::class.java).getSuperHeroDetail(imdbID = imdbID)
            if (response.body() != null) {
                runOnUiThread {
                    createUI(response.body()!!)
                }
            }
        }
    }

    private fun createUI(superHero: SuperHeroDetailResponse) {
        Picasso.get().load(superHero.poster).into(mBinding.ivSuperHero)
        mBinding.tvSuperHeroName.text = superHero.title
        // Rating
        setRating(superHero.imdbRating)
        mBinding.tvRating.text = superHero.imdbRating
    }

    private fun setRating(imdbRating: String) {
        updateHeight(mBinding.vRating, imdbRating)
    }

    private fun updateHeight(view: View, rating: String) {
        val params = view.layoutParams
        params.height = pixelToFloat(rating.toFloat() * 10F)
        view.layoutParams = params
    }

    private fun pixelToFloat(pixel: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            pixel,
            resources.displayMetrics
        )
            .roundToInt()
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
