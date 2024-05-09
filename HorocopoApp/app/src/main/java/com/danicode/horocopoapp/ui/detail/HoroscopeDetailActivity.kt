package com.danicode.horocopoapp.ui.detail

import android.os.Bundle

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.danicode.horocopoapp.R
import com.danicode.horocopoapp.databinding.ActivityHoroscopeDetailBinding
import com.danicode.horocopoapp.domain.model.HoroscopeModel.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

// Colocar anotacion "@AndroidEntryPoint" para que pueda ser inyectada o inyecte a otra clase
@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityHoroscopeDetailBinding

    // Acceder al viewModel
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    // Recuperar signo sodiacal que se mando desde HoroscopeFragment
    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        horoscopeDetailViewModel.getHoroscope(args.zodiacSign)
        initUI()
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        mBinding.ivbBack.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState(it)
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        mBinding.pbDescription.isVisible = true
    }

    private fun errorState(horoscopeDetailState: HoroscopeDetailState.Error) {
        mBinding.pbDescription.isVisible = false
        mBinding.tvDescription.text = horoscopeDetailState.error
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        mBinding.pbDescription.isVisible = false
        mBinding.tvZodiac.text = state.sign
        mBinding.tvDescription.text = state.data

        val imageZodiac = when (state.horoscopeModel) {
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }

        mBinding.ivZodiac.setImageResource(imageZodiac)
    }
}